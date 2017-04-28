package com.sl.nicefish.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	
	
	/**
	 * 返回日期时间命名的文件夹
	 * 20170428154308
	 * @return
	 */
	public static String format(String formatType){
		DateFormat df = new SimpleDateFormat(formatType);
		Calendar calendar = Calendar.getInstance();
		String imageName = df.format(calendar.getTime());
		return imageName;
	} 
	
	public static void main(String[] args) {
		System.out.println(format("yyyyMMhhddmmss"));
	}
}

