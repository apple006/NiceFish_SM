package com.sl.nicefish.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	 * @param DirName 文件上传目录
	 * @return
	 */
	public static String upload(HttpServletRequest request, String DirName){
		
		//创建一个通用的多部分解析器
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		//图片名称
		String fileName = null;
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
						String realPath = request.getSession().getServletContext().getRealPath("/"+ DirName);
						System.out.println("realPath:"+realPath);
						//如果路径不存在，则创建该路径
						File realPathDir = new File(realPath);
						if(realPathDir==null || !realPathDir.exists()) {
							realPathDir.mkdirs();
						}
						//重新命名上传后的文件名 20170403284634.jpg 
						fileName = DateUtil.format("yyyyMMddHHmmss")+"."+suffix;
						System.err.println("fileName:"+fileName);
						//定义上传路径
						File uploadFile = new File(realPathDir+File.separator+fileName);
						System.out.println(uploadFile);
						
					}
				}
				
				//记录上传该文件后的时间
				long endTime = System.currentTimeMillis();
				
				System.out.println("用时:"+String.valueOf(endTime-startTime)+"毫秒");
			}
			
		}
		
		return fileName;
	}
	
	/**
	 * ckeditor文件上传功能，回调，传回图片路径，实现预览效果
	 * @param request
	 * @param response
	 * @param DirectoryName
	 * @throws IOException
	 */
	public static void ckeditor(HttpServletRequest request, HttpServletResponse response, String DirectoryName)
            throws IOException {
        String fileName = upload(request, DirectoryName);
        // 结合ckeditor功能
        // imageContextPath为图片在服务器地址，如upload/123.jpg,非绝对路径
        String imageContextPath = request.getContextPath() + "/" + DirectoryName + "/" + fileName;
        System.out.println("imageContextPath:"+imageContextPath);
        response.setContentType("text/html;charset=UTF-8");
        String callback = request.getParameter("CKEditorFuncNum");
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + imageContextPath + "',''" + ")");
        out.println("</script>");
        out.flush();
        out.close();
    }
	
}
