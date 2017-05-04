package com.sl.nicefish.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.nicefish.dao.ClassifyMapper;
import com.sl.nicefish.pojo.Classify;
import com.sl.nicefish.service.IClassifyService;

@Service("classifyService")
public class ClassifyServiceImpl extends AbstractBaseServiceImpl<Classify,String> 
	implements IClassifyService {
	
	@Autowired
	private ClassifyMapper classifyMapper;
	
	@Override
	public void setBaseMapper() {
		super.setBaseMapper(classifyMapper);
	}

	@Override
	public List<Classify> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
