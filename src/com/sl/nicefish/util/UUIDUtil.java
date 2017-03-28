package com.sl.nicefish.util;

import java.util.UUID;

public class UUIDUtil {
	
	public static String generate(){
		String uuidStr = UUID.randomUUID().toString();
		return uuidStr.replace("-","");
	}
	
}
