package com.sl.nicefish.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class BaseController {
	
	protected String pageListResponse(){
		Map<String, Object > map = new HashMap<String,Object>();
		return null;
	}
	
	protected Map<String, Object> ajaxSuccessResponse(){
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		return result;
	}
	
	protected Map<String, Object> ajaxSuccessResponse(String msg){
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		if(StringUtils.isNotBlank(msg) && StringUtils.isNotEmpty(msg)){
			result.put("msg", msg);
		}
		return result;
	}
	
	protected Map<String, Object> ajaxFailureResponse(){
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("failure", true);
		return result;
	}
	
	protected Map<String, Object> ajaxFailureResponse(String msg){
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("failure", true);
		if(StringUtils.isNotBlank(msg) && StringUtils.isNotEmpty(msg)){
			result.put("msg", msg);
		}
		return result;
	}
	
}
