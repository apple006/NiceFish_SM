package com.sl.nicefish.service.impl;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.sl.nicefish.service.IVerifyCodeService;
import com.sl.nicefish.util.VerifyCodeUtil;

@Service("verifyCodeService")
public class VerifyCodeServiceImpl implements IVerifyCodeService {
	
	@Override
	public void getCode(HttpServletRequest request, HttpServletResponse response,String createType) {
			try {
				VerifyCodeUtil.createImage(request, response, createType);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
