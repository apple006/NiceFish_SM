package com.sl.nicefish.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.InvalidContentTypeException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;


public class UMUploadImageUtil {
	// 输出文件地址
	//private static String url = "";
	// 上传文件名
	//private static String fileName = "";
	// 状态
	//private static String state = "";
	// 文件类型
	//private static String type = "";
	// 原始文件名
	//private static String originalName = "";
	// 文件大小
	//private static long size = 0;
	//private String title = "";
	private static String[] allowFiles = { ".rar", ".doc", ".docx", ".zip", ".pdf",".txt", ".swf", ".wmv", ".gif", ".png", ".jpg", ".jpeg", ".bmp" };
	public static int maxSize = 10000;//kb
	private static HashMap<String, String> errorInfo = new HashMap<String, String>();
	static{
		errorInfo.put("SUCCESS", "SUCCESS"); //默认成功
		errorInfo.put("NOFILE", "未包含文件上传域");
		errorInfo.put("TYPE", "不允许的文件格式");
		errorInfo.put("SIZE", "文件大小超出限制");
		errorInfo.put("ENTYPE", "请求类型ENTYPE错误");
		errorInfo.put("REQUEST", "上传请求异常");
		errorInfo.put("IO", "IO异常");
		errorInfo.put("DIR", "目录创建失败");
		errorInfo.put("UNKNOWN", "未知错误");
	}
	public static String state="";
	
	public static Map<String,String> upload(HttpServletRequest request,HttpServletResponse response,String imageDir){
		String title="";
		Map<String,String> map = new HashMap<>();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			map.put("state", errorInfo.get("NOFILE"));
			return map;
		}
		
		DiskFileItemFactory dff = new DiskFileItemFactory();
		String servletPath = request.getServletPath();
		String realPath = request.getSession().getServletContext()
				.getRealPath(servletPath);
		
		String savePath= getFolder(new File(realPath).getParent() +"/" +imageDir);//最终保存的物理路径
		
		dff.setRepository(new File(savePath));
			
		try {
			ServletFileUpload sfu = new ServletFileUpload(dff);
			sfu.setSizeMax(10000 * 1024);
			sfu.setHeaderEncoding("utf-8");
			FileItemIterator fii = sfu.getItemIterator(request);
			while (fii.hasNext()) {
				FileItemStream fis = fii.next();
				if (!fis.isFormField()) {
					//原始文件名
					String originalName = fis.getName().substring(fis.getName().lastIndexOf(System.getProperty("file.separator")) + 1);//原始名
					if (!checkFileType(originalName)) {
						map.put("state", errorInfo.get("TYPE"));
						continue;
					}
					//新命名
					String fileName = getName(originalName);
					map.put("originalName", originalName);
					map.put("fileName", fileName);
					String type = getFileExt(fileName);
					map.put("type", type);
					String url = savePath + "/" + fileName;
					System.out.println("url:"+url);
					map.put("url", url);
					
					BufferedInputStream in = new BufferedInputStream(fis.openStream());
					
					File file = new File(new File(realPath).getParent()+"/" +url);
					
					FileOutputStream out = new FileOutputStream( file );
					BufferedOutputStream output = new BufferedOutputStream(out);
					Streams.copy(in, output, true);
					state=errorInfo.get("SUCCESS");
					long size = file.length();//源文件大小
					map.put("size", String.valueOf(size));
					//UE中只会处理单张上传，完成后即退出
					break;
				} else {
					String fname = fis.getFieldName();
					//只处理title，其余表单请自行处理
					if(!fname.equals("pictitle")){
						continue;
					}
                    BufferedInputStream in = new BufferedInputStream(fis.openStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuffer result = new StringBuffer();  
                    while (reader.ready()) {  
                        result.append((char)reader.read());  
                    }
                    title = new String(result.toString().getBytes(),"utf-8");
                    reader.close();  
                    
				}
			}
		} catch (SizeLimitExceededException e) {
			state = errorInfo.get("SIZE");
		} catch (InvalidContentTypeException e) {
			state = errorInfo.get("ENTYPE");
		} catch (FileUploadException e) {
			state = errorInfo.get("REQUEST");
		} catch (Exception e) {
			state = errorInfo.get("UNKNOWN");
		}
			
		return map;
		
		
	}
	/**
	 * 根据字符串创建本地目录 并按照日期建立子目录返回
	 * @param path 
	 * @return 
	 */
	private static String getFolder(String path) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
		path += "/" + formater.format(new Date());
		File dir = new File(path);
		if (!dir.exists()) {
			try {
				dir.mkdirs();
			} catch (Exception e) {
				errorInfo.get("DIR");
				return "";
			}
		}
		return path;
	}
	
	/**
	 * 文件类型判断
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean checkFileType(String fileName) {
		System.out.println("fileName:"+fileName);
		Iterator<String> type = Arrays.asList(allowFiles).iterator();
		while (type.hasNext()) {
			String ext = type.next();
			if (fileName.toLowerCase().endsWith(ext)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 依据原始文件名生成新文件名
	 * @return
	 */
	private static String getName(String fileName) {
		Random random = new Random();
		return fileName = "" + random.nextInt(10000)
				+ System.currentTimeMillis() + getFileExt(fileName);
	}
	
	/**
	 * 获取文件扩展名
	 * 
	 * @return string
	 */
	private static String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}
}
