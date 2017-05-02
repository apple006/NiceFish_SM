package com.sl.nicefish.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.sl.nicefish.util.ImageUploadUtil;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@RequestMapping(value="image",method=RequestMethod.POST)
	public void imageUpload(HttpServletRequest request, HttpServletResponse response){
        try {
            ImageUploadUtil.upload(request, response);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@RequestMapping("springUpload")
    public void  springUpload(HttpServletRequest request) throws IllegalStateException, IOException
    {
         long  startTime=System.currentTimeMillis();
         //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
             
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path="E:/springUpload"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
                 
            }
           
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");
    }
	
	@RequestMapping("preView")
	public String preView(HttpServletRequest request){
		//获取上传文件的目录
		String uploadFilePath = request.getServletContext().getRealPath("/upload");
		//存储要下载的文件名
				Map<String,String> filenameMap = new HashMap<String,String>();
				File file = new File(uploadFilePath);
				if(!file.exists()){
					request.setAttribute("filenameMap", "");
					System.out.println(filenameMap.toString());
					System.out.println("下载文件为空");
				}else{
					//递归遍历filepath 目录下所有的文件和和目录，将文件的文件名存储到map中
					ImageUploadUtil.listFile(new File(uploadFilePath),filenameMap);
					//将Map集合发送到listfile.jsp页面进行显示
					request.setAttribute("filenameMap", filenameMap);
					System.out.println(filenameMap.toString());
				}
			return "listfile";
	}
}

