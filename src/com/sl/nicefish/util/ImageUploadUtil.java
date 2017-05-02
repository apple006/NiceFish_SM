package com.sl.nicefish.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


public class ImageUploadUtil {
	
	public static final String JPG = "jpg";
	public static final String JPEG = "jpeg";
	public static final String PNG = "png";
	public static final String GIF = "gif";
	public static final String BMP = "bmp";
	
	public static final String UPLOAD_DIR="upload";//存放上传文件的目录名
	
	private static List<String> types = new ArrayList<>();
	static {
		types.add(JPG);
		types.add(JPEG);
		types.add(PNG);
		types.add(GIF);
		types.add(BMP);
	}
	
	/**
	 * 图片上传
	 * @param request
	 * @param dirName 文件上传目录
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public static String upload(HttpServletRequest request,HttpServletResponse response) 
			throws IllegalStateException, IOException{
		//创建一个通用的多部分解析器
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		//图片名称
		//判断 request 是否有文件上传，即多部分请求
		if(resolver.isMultipart(request)){
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			
			while(iter.hasNext()){
				// 记录上传过程起始的时间，用来计算上传时间
				long startTime = System.currentTimeMillis();
				
				// 取得文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if(file != null){
					// 取得当前上传文件的名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为"" ，说明该文件存在
					if(myFileName.trim() != ""){
						//获得图片的原始名称
						String originalFileName = file.getOriginalFilename();
						//获取图片的后缀名称,如果不为图片格式则不上传
						String suffix = originalFileName.substring(originalFileName.lastIndexOf(".")+1).toLowerCase();
						if(!types.contains(suffix)){
							continue;
						}
						// 获得上传路径的绝对路径地址(/upload)-->
						String realPath = request.getSession().getServletContext().getRealPath("/"+UPLOAD_DIR);
						
						String dateDir = DateUtil.format("yyyyMMddHH");
						
						String finalSavePath = realPath+"\\"+dateDir;
						
						File fileDir = new File(finalSavePath);
						if(!fileDir.exists()){
							fileDir.mkdirs();
						}
						
						
						System.out.println("finalSavePath:"+finalSavePath);
						
						//重新命名上传后的文件名 20170403284634.jpg 
						
						String fileName = makeFileName(myFileName);
						
						System.out.println("fileName:"+fileName);
						//定义上传路径
						File uploadFile = new File(finalSavePath+File.separator+fileName);
						
						System.out.println("uploadFilePath:"+uploadFile);
						
						//存储文件到web服务器
						file.transferTo(uploadFile);
						
						
						System.out.println(finalSavePath+File.separator+fileName);
						
						String imageContextPath = request.getContextPath() + "/" + UPLOAD_DIR + "/" +dateDir+"/"+fileName;
						System.out.println(imageContextPath);
						response.setContentType("text/html;charset=UTF-8");
				        response.setCharacterEncoding("utf-8");
				        String callback = request.getParameter("CKEditorFuncNum");
				        PrintWriter out = response.getWriter();
				        out.println("<script type=\"text/javascript\">");
				        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + imageContextPath + "',''" + ")");
				        out.println("</script>");
				        out.flush();
				        out.close();
					}
				}
				
				//记录上传该文件后的时间
				long endTime = System.currentTimeMillis();
				System.out.println("用时:"+String.valueOf(endTime-startTime)+"毫秒");
			}
			
		}
		
		return "success";
	}
	
	/**
	 * ckeditor文件上传功能，回调，传回图片路径，实现预览效果
	 * @param request
	 * @param response
	 * @param DirectoryName
	 * @throws IOException
	 */
	public static void ckeditor(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String imageContextPath = upload(request,response);
        
        // 结合ckeditor功能
        // imageContextPath为图片在服务器地址，如upload/123.jpg,非绝对路径
        System.out.println(UPLOAD_DIR);
       imageContextPath =  request.getContextPath()+imageContextPath.substring(imageContextPath.indexOf(UPLOAD_DIR),imageContextPath.length());
       /// System.out.println(filePath);
       // String imageContextPath = request.getContextPath() + File.separator + UPLOAD_DIR + File.separator + filePath;
        System.out.println("imageContextPath:"+imageContextPath);
        
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String callback = request.getParameter("CKEditorFuncNum");
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + imageContextPath + "',''" + ")");
        out.println("</script>");
        out.flush();
        out.close();
    }
	
	public static void view(HttpServletRequest request, HttpServletResponse response, String DirectoryName)
            throws IOException {
		//String imageContextPath = request.getContextPath() + "/" + DirectoryName + "/" + fileName;
		
	}
	
	/**
	 * 得到文件保存的名称
	 * 为了防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名 
	 * @param filename
	 * @return
	 */
	private static String makeFileName(String filename) {
		
		return UUIDUtil.generate()+"_"+filename;
	}
	
	/**
	 * 上传文件保存的最终文件夹
	 * @param serverPath 
	 * @return
	 */
	private static String makeFileDir(String serverPath){
		String dir = serverPath + "\\" + "image_"+DateUtil.format("yyyyMMddHH");  //upload\2\3  upload\3\5
		//File既可以代表文件也可以代表目录
		File file = new File(dir);
		//如果目录不存在
		if(!file.exists()){
			//创建目录
			file.mkdirs();
		}
		return dir;
	}
	
	/**
	 * 递归遍历指定目录下面的所有文件
	 * @param file
	 * @param filenameMap
	 */
	public static void listFile(File file, Map<String, String> filenameMap) {
		//如果file 代表的不是一个文件，而是一个目录
		if(!file.isFile()){
			//列出该目录下面的所有文件和目录
			File[] files = file.listFiles();
			//遍历files[] 数组
			for (File file2 : files) {
				//递归
				listFile(file2,filenameMap);
			}
		}else{
			String realName = file.getName().substring(file.getName().indexOf("_")+1);
			filenameMap.put(file.getName(), realName);
		}
	}
	
	public static void main(String[] args) {
		String text= "G:\\apache-tomcat-8.5.11\\webapps\\NiceFish\\WEB-INF\\upload\\2017050214\\790a0536-c17e-4306-9950-bc60b89ebc32_nicefish.png";
		System.out.println(text.substring(text.indexOf("WEB-INF"), text.length()));
	}
}
