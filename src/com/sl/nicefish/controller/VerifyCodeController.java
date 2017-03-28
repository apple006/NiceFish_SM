package com.sl.nicefish.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sl.nicefish.service.IVerifyCodeService;

@Controller
@RequestMapping("/code")
public class VerifyCodeController {
	
	@Autowired
	private IVerifyCodeService verifyCodeService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public void getCode(String createType,HttpServletRequest request, HttpServletResponse response){
		try {
			verifyCodeService.getCode(request, response,createType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
