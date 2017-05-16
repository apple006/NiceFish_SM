package com.sl.nicefish.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.baidu.ueditor.um.Uploader;
import com.sl.nicefish.util.ImageUploadUtil;
import com.sl.nicefish.util.UMUploadImageUtil;

@Controller
@RequestMapping("/upload")
public class UploadController {
	@RequestMapping(value = "umimage1")
	public void upload(@RequestParam("upfile") MultipartFile upfile, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	    Uploader up = new Uploader(request);
	    up.setSavePath("upload");
	    String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
	    up.setAllowFiles(fileType);
	    up.setMaxSize(10000); //单位KB
	    up.upload();

	    String callback = request.getParameter("callback");

	    String result = "{\"name\":\""+ up.getFileName() +"\", \"originalName\": \""+ up.getOriginalName() +"\", \"size\": "+ up.getSize() +", \"state\": \""+ up.getState() +"\", \"type\": \""+ up.getType() +"\", \"url\": \""+ up.getUrl() +"\"}";

	    result = result.replaceAll( "\\\\", "\\\\" );

	    if( callback == null ){
	        response.getWriter().print( result );
	    }else{
	        response.getWriter().print("<script>"+ callback +"(" + result + ")</script>");
	    }
	}

	@RequestMapping(value = "umimage", produces = "text/html;charset=UTF-8")
	public void UMImageUpload(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		// Uploader up = new Uploader(request);
		// System.out.println(up.getState());
		// System.out.println(up.getFileName());
		// up.setSavePath("image");
		// String[] fileType = { ".gif", ".png", ".jpg", ".jpeg", ".bmp" };
		// up.setAllowFiles(fileType);
		// up.setMaxSize(20000); // 单位KB
		try {
			Map<String, String> map = UMUploadImageUtil.upload(request, response, "image");
			System.out.println(map.toString());
			String callback = request.getParameter("callback");
			String result = "{\"name\":\"" + map.get("fileName") + "\", \"originalName\": \"" + map.get("originalName")
					+ "\", \"size\": " + map.get("size") + ", \"state\": \"" + map.get("state") + "\", \"type\": \""
					+ map.get("type") + "\", \"url\": \"" + map.get("url") + "\"}";

			result = result.replaceAll("\\\\", "\\\\");
			System.out.println(result);
			if (callback == null) {
				try {
					response.getWriter().print(result);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				response.getWriter().print("<script>" + callback + "(" + result + ")</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "image", method = RequestMethod.POST)
	public void imageUpload(HttpServletRequest request, HttpServletResponse response) {
		try {
			ImageUploadUtil.upload(request, response);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("springUpload")
	public void springUpload(HttpServletRequest request) throws IllegalStateException, IOException {
		long startTime = System.currentTimeMillis();
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					String path = "E:/springUpload" + file.getOriginalFilename();
					// 上传
					file.transferTo(new File(path));
				}

			}

		}
		long endTime = System.currentTimeMillis();
		System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");
	}

	@RequestMapping("preView")
	public String preView(HttpServletRequest request) {
		// 获取上传文件的目录
		String uploadFilePath = request.getServletContext().getRealPath("/upload");
		// 存储要下载的文件名
		Map<String, String> filenameMap = new HashMap<String, String>();
		File file = new File(uploadFilePath);
		if (!file.exists()) {
			request.setAttribute("filenameMap", "");
			System.out.println(filenameMap.toString());
			System.out.println("下载文件为空");
		} else {
			// 递归遍历filepath 目录下所有的文件和和目录，将文件的文件名存储到map中
			ImageUploadUtil.listFile(new File(uploadFilePath), filenameMap);
			// 将Map集合发送到listfile.jsp页面进行显示
			request.setAttribute("filenameMap", filenameMap);
			System.out.println(filenameMap.toString());
		}
		return "listfile";
	}
}
