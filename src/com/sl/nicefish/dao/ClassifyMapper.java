package com.sl.nicefish.dao;

import java.util.List;

import com.sl.nicefish.pojo.Classify;

public interface ClassifyMapper extends BaseMapper<Classify, String> {
	
	/**
	 * 获取分类列表
	 * @return
	 */
    List<Classify> getList();
}