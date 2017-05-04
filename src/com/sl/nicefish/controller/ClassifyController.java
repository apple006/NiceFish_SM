package com.sl.nicefish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sl.nicefish.pojo.Classify;
import com.sl.nicefish.service.IClassifyService;


@Controller
@RequestMapping("classify")
public class ClassifyController extends BaseController{
	
	@Autowired
	private IClassifyService classifyService;
	
	@RequestMapping()
	public String getList(){
		
		List<Classify> list = classifyService.getList();
		
		return null;
	}
	
	
}
