package com.sl.nicefish.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 验证码
 * @author ZhangJing
 *
 */
public interface IVerifyCodeService {
	/**
	 * 获取验证码
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	void getCode(HttpServletRequest request, HttpServletResponse response, String createType);
}
