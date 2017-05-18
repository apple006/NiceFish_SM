package com.sl.nicefish.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.nicefish.dao.ClassifyMapper;
import com.sl.nicefish.pojo.Classify;
import com.sl.nicefish.service.IClassifyService;

@Service("classifyService")
public class ClassifyServiceImpl implements IClassifyService
	 {
	
	@Autowired
	private ClassifyMapper classifyMapper;
	
	@Override
	public List<Classify> getList() {
		// TODO Auto-generated method stub
		return classifyMapper.getList();
	}
	
	@Override
	public int insertRecord(Classify classify) {
		// TODO Auto-generated method stub
		return classifyMapper.insertSelective(classify);
	}

	
}
