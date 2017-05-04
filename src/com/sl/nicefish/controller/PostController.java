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
import com.sl.nicefish.util.ConstSessionName;
import com.sl.nicefish.util.JSONUtil;
import com.sl.nicefish.util.ResultUtil;
import com.sl.nicefish.util.UUIDUtil;

@Controller
@RequestMapping("/post")
public class PostController extends BaseController{
	
	@Autowired
	private IPostService postService;
	
	public final static int pageSize=10;
	
	/**
	 * 查询文章列表
	 * @param pageIndex
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/listpage/{pageIndex}",method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getList(@PathVariable int pageIndex,Model model){
		Page<?> page = PageHelper.startPage(pageIndex, pageSize, true);
		//获得查询结果
		List<Post> list = postService.getList();
		if(list!=null){
			return jsonResultWithPage(list, page,ConstSessionName.successQueryInfo);
		}
		return jsonResultWithMsg("Server Error",ConstSessionName.failureQueryInfo);
	}
	
	/**
	 * 根据postId 查询文章详情
	 * @param postId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/detail/{postId}", method=RequestMethod.GET, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String postDetail(@PathVariable String postId, Model model) {
		Post post = postService.getById(postId);
		if(post!=null){
			return jsonResultNoPage(post,ConstSessionName.successQueryInfo);
		}
		return jsonResultWithMsg("Server Error",ConstSessionName.failureQueryInfo);
	}
	
	/**
	 * 新增文章
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/save" ,method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String save(String data){
		System.out.println(data);
		//将 JSON 字符串转为 post 对象
		Post post= JSONUtil.JSONToObect(data, Post.class); 
		post.setPostId(UUIDUtil.generate());
		post.setCreateTime(new Date());
		post.setLastModifyTime(new Date());
		post.setUserId("8d2a7444767f4051a0628b02e45b3e79");
		post.setUserName("zhangfei");
		post.setStatus(0);
		post.setModifyUserid(post.getUserId());
		System.out.println(post.toString());
		int i = postService.insert(post);
		if(i==1){
			return jsonResultNoPage(post,ConstSessionName.successInsertInfo);
		}
		return jsonResultWithMsg("Server Error",ConstSessionName.failureInsertInfo);
	}
	
	/**
	 * 根据postId 删除文章
	 * @param postId
	 * @return
	 */
	@RequestMapping(value="/delete/{postId}", method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String delete(@PathVariable String postId){
		System.out.println(postId);
		int i = postService.delete(postId);
		if(i==1){
			return jsonResultNoPage("",ConstSessionName.successDeleteInfo);
		}
		return jsonResultWithMsg("Server Error",ConstSessionName.failureDeleteInfo);
	}
}
