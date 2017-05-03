package com.sl.nicefish.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sl.nicefish.pojo.Post;
import com.sl.nicefish.service.IPostService;
import com.sl.nicefish.util.ResultUtil;
import com.sl.nicefish.util.UUIDUtil;

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
		return ResultUtil.jsonResultWithPage(page, list);
	}
	
	@RequestMapping(value="/detail/{postId}", method=RequestMethod.GET, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String postDetail(@PathVariable String postId, Model model) {
		Post post = postService.getById(postId);
		return ResultUtil.jsonResultDetail(post);
	}
	
	@RequestMapping(value="/save" ,method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String save(String data){
		System.out.println(data);
		JSONObject obj = JSONObject.parseObject(data);
		System.out.println(obj);
		net.sf.json.JSONObject jsonobject = net.sf.json.JSONObject.fromObject(data);
		Post post= (Post)net.sf.json.JSONObject.toBean(jsonobject,Post.class);
		//Post post = JSONObject.toJavaObject(obj, Post.class);
		post.setPostId(UUIDUtil.generate());
		post.setCreateTime(new Date());
		post.setLastModifyTime(new Date());
		post.setUserId("8d2a7444767f4051a0628b02e45b3e79");
		post.setUserName("zhangfei");
		post.setStatus(0);
		post.setModifyUserid(post.getUserId());
		System.out.println(post.toString());
		int i = postService.insert(post);
		Map<String,Object> map = new HashMap<>();
		if(i == 0){
			map.put("data", "success");
		}
		else {
			map.put("data", "fail");
		}
		return JSONObject.toJSONString(map);
		
	}
}
