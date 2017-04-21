package com.sl.nicefish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sl.nicefish.pojo.Post;
import com.sl.nicefish.service.IPostService;
import com.sl.nicefish.util.ResultUtil;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private IPostService postService;
	
	public final static int pageSize=5;
	
	@RequestMapping(value="/listpage/{pageIndex}",method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getList(@PathVariable int pageIndex,Model model){
		Page<?> page = PageHelper.startPage(pageIndex, pageSize, true);
		
		//获得查询结果
		List<Post> list = postService.getList();
		System.out.println("======="+list.toString());
		System.out.println(page);
//	
		return ResultUtil.jsonStringResult(page, list);
	}
	
	@RequestMapping(value="/detail/{postId}", method=RequestMethod.GET, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String postDetail(@PathVariable String postId, Model model) {
		Post post = postService.getById(postId);
		return ResultUtil.jsonDetail(post);
	}
	
}
