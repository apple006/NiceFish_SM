package com.sl.nicefish.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sl.nicefish.pojo.User;
import com.sl.nicefish.service.IUserService;
@Controller
@RequestMapping("/user")
public class UserController {
	//TODO: 抽到数据库系统配置表中
	private final static int pageSize = 10; 
	
	@Autowired
	private IUserService userSerivce;
	
	ObjectMapper objectMapper=new ObjectMapper();
	
	@RequestMapping(value = "/listpage/{pageIndex}", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String listPage(@PathVariable int pageIndex, Model model,HttpServletResponse response) throws Exception{
		//开启PageHelper
		Page<?> page = PageHelper.startPage(pageIndex, pageSize, true);
		//获得查询结果
		List<User> list = userSerivce.getList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", page.getTotal());//总数
		map.put("list", list);
		System.out.println(objectMapper.writeValueAsString(map));
		return objectMapper.writeValueAsString(map);
	}
	
	/**
	 * 通过id获取用户信息
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="{userId}")
	@ResponseBody
	public User getUserById(@PathVariable("userId") String userId){
		return userSerivce.getUserById(userId);
	}
	
	
}
