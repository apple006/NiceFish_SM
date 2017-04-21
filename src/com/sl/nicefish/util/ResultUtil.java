package com.sl.nicefish.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;

public class ResultUtil {
	
	/**
	 * 分页信息
	 * @param pageNum 当前页
	 * @param PageSize 页容量
	 * @param pageCount 总页数
	 * @param total 数据总条数
	 * @return
	 */
	public static Map<String,Object> pageInfo(int currentPage,int pageSize, int pageCount,long total){
		Map<String, Object> map = new HashMap<>();
		map.put("currentPage", currentPage);
		map.put("pageSize", pageSize);
		map.put("pageCount", pageCount);
		map.put("total", total);
		return map;
		
	}
	
	/**
	 * 通过PageHelper 获取分页信息
	 * @param page
	 * @return
	 */
	public static Map<String,Object > pageInfo(Page<?> page){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("currentPage", page.getPageNum());
		map.put("pageSize", page.getPageSize());
		map.put("pageCount", page.getPages());
		map.put("total", page.getTotal());
		map.put("startRow", page.getStartRow());
		map.put("endRow", page.getEndRow());
		return map;
	}
	
	/** 返回列表的map集合
	 * @param page
	 * @param list
	 * @return
	 */
	public static Map<String,Object> mapResult(Page<?> page,List<?> list){
		Map<String,Object> map = pageInfo(page);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 返回列表的json字符串
	 * @param page
	 * @param list
	 * @return
	 */
	public static String jsonStringResult(Page<?> page, List<?> list){
		Map<String,Object> map = mapResult(page, list);
		return JSONObject.toJSONString(map);
	}
	
	/**
	 * 返回详情数据
	 * @param obj
	 * @return
	 */
	public static String jsonDetail(Object obj){
		Map<String, Object> map = new HashMap<>();
		if(obj !=null){
			map.put("data", obj);
			map.put("info", "success");
		}else {
			map.put("data", "无数据");
			map.put("info", "fail");
		}
		
		return JSONObject.toJSONString(map);
	}
}
