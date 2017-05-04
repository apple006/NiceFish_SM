package com.sl.nicefish.util;

import net.sf.json.JSONObject;

public class JSONUtil {
	
	/**
	 * 将JSON 字符串转为 Java 对象
	 * @param jsonStr
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T>  T JSONToObect(String jsonStr,Class<T> clazz){
		JSONObject obj = JSONObject.fromObject(jsonStr);
		return (T) JSONObject.toBean(obj,clazz);
	}
	
}
