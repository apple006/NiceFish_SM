package com.sl.nicefish.util;

import java.util.Iterator;
import java.util.Set;

import com.sl.nicefish.pojo.Post;

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
		return (T) JSONObject.toBean(transJSONObjectToLowerCase(obj),clazz);
	}
	
	/**
	 * 将JSONObject 的key 转为小写
	 * @param obj
	 * @return
	 */
	public static JSONObject transJSONObjectToLowerCase(JSONObject obj){
		if(!obj.isEmpty()){
			JSONObject o = new JSONObject();
			Iterator<String> keys =  obj.keys();
			while(keys.hasNext()){
				String key = keys.next();
				o.put(key.toLowerCase(), obj.opt(key));
			}
			return o;
		}
		return null;
	}
	
	public static void main(String[] args) {
		String jsonStr ="{\"posttitle\":\"rt53\",\"postContent\":\"PHA%2BPGltZyBzcmM9Imh0dHA6Ly93d3cubmljZWZpc2guY29tOjkwMDAvdXBsb2FkL2ltYWdlcy8yMDE3MDUxOC83ODkxNDk1MDc2MjM4NTI0LmpwZyIvPjwvcD4%3D\",\"isOriginal\":\"0\",\"enableComment\":\"0\",\"classifyId\":\"2\"}";
		Post p = JSONToObect(jsonStr, Post.class);
		System.out.println(p.toString());
	}
}
