package com.sl.nicefish.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.sl.nicefish.util.ConstSessionName;


public class BaseController {
	
	/**
	 * 查询列表，返回JSON字符串
	 * @param list 数据集合
	 * @param page PageHelper
	 * @return
	 */
	protected  String  jsonResultWithPage(List<?> list,Page<?> page,String info){
		
		Map<String, Object> map = pageInfo(page);
		Map<String, Object > map2 = successResultMap(list,info);
		map.putAll(map2);
		return JSONObject.toJSONString(map);
	}
	
	/**
	 * 
	 * 查询无分页的列表(文章分类),详细、新增记录、删除记录
	 * 返回 JSON 字符串
	 * @param t 实体
	 * @return
	 */
	protected <T> String jsonResultNoPage(T t,String info){
		Map<String,Object> map = successResultMap(t,info);
		return JSONObject.toJSONString(map);
	}
	
	/**
	 * 请求失败，返回JSON 字符串
	 * @param msg 错误信息说明
	 * @return
	 */
	protected String jsonResultWithMsg(String msg, String info){
		Map<String,Object> map = failureResultMap(msg,info);
		return JSONObject.toJSONString(map);
	}
	
	/**
	 * 通过PageHelper 获取分页信息
	 * @param page
	 * @return
	 */
	private  Map<String,Object > pageInfo(Page<?> page){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("currentPage", page.getPageNum());
		map.put("pageSize", page.getPageSize());
		map.put("pageCount", page.getPages());
		map.put("total", page.getTotal());
		map.put("startRow", page.getStartRow());
		map.put("endRow", page.getEndRow());
		return map;
	}
	
	/**
	 * 成功返回的 map
	 * @param t
	 * @return
	 */
	private <T> Map<String, Object > successResultMap( T t, String info){
		Map<String, Object> map = new HashMap<>();
		map.put(ConstSessionName.DATA, t);
		map.put(ConstSessionName.INFO, info);
		map.put(ConstSessionName.STATUS, ConstSessionName.successStatus);
		return map;
	}
	
	/**
	 * 失败返回的 map
	 * @return
	 */
	private Map<String, Object > failureResultMap(String msg, String info){
		Map<String, Object> map = new HashMap<>();
		
		if(StringUtils.isNotBlank(msg)&&StringUtils.isNotEmpty(msg)){
			map.put(ConstSessionName.MESSAGE, msg);
		}
		map.put(ConstSessionName.DATA, "");
		map.put(ConstSessionName.INFO, info);
		map.put(ConstSessionName.STATUS, ConstSessionName.successStatus);
		return map;
	}

	
	
}
