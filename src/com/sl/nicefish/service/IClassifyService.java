package com.sl.nicefish.service;

import java.util.List;

import com.sl.nicefish.pojo.Classify;

public interface IClassifyService {
	
	//查询所有文章分类
	List<Classify> getList();
	//批量删除文章分类
	//int batchDelete(String[] ids);
	
	
}
