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
	
	/*@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(@RequestBody User user, HttpSession session){
		
		User userDB = userService.getUserById(user.getUpId());
		
		if(null == userDB){
			return this.failureResponse("用户名或者密码错误");
		}
		if(!userDB.getPassword().equals(user.getPassword())){
			return this.failureResponse("用户名或者密码错误");
		}
		session.setAttribute(ConstSessionName.UserInfo, userDB);
		return this.successResponse();
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> register(@RequestBody User user) throws Exception{
		if(1==this.userService.insert(user)){
			return this.successResponse();
		}
		return this.failureResponse();
	}
	*/
}
