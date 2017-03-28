package com.sl.nicefish.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sl.nicefish.pojo.User;
import com.sl.nicefish.service.IUserService;
import com.sl.nicefish.util.ConstSessionName;

@Controller
@RequestMapping("/access")
public class AccessController extends BaseController{
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(@RequestBody User user, HttpSession session){
		
		System.out.println(user);
		User userDB = userService.getUserById(user.getUserId());
		
		if(null == userDB){
			return this.ajaxFailureResponse("用户名或者密码错误");
		}
		if(!userDB.getPassword().equals(user.getPassword())){
			return this.ajaxFailureResponse("用户名或者密码错误");
		}
		session.setAttribute(ConstSessionName.UserInfo, userDB);
		return this.ajaxSuccessResponse();
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> register(@RequestBody User user) throws Exception{
		if(1==this.userService.insert(user)){
			return this.ajaxSuccessResponse();
		}
		return this.ajaxFailureResponse();
	}
	
}
