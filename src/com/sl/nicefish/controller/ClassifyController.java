package com.sl.nicefish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sl.nicefish.pojo.Classify;
import com.sl.nicefish.service.IClassifyService;
import com.sl.nicefish.util.ConstSessionName;
import com.sl.nicefish.util.JSONUtil;
import com.sl.nicefish.util.UUIDUtil;


@Controller
@RequestMapping("/classify")
public class ClassifyController extends BaseController{
	
	@Autowired
	private IClassifyService classifyService;
	
	@RequestMapping(value="/list",method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getList(Model model){
		//Page<?> page = PageHelper.startPage(pageIndex, pageSize, true);
		//获得查询结果
		List<Classify> list = classifyService.getList();
		System.out.println(list);
		if(null==list){
			return jsonResultWithMsg("Server Error",ConstSessionName.failureQueryInfo);
		}else if( list.isEmpty()){
			return jsonResultWithMsg("没有查到分类数据",ConstSessionName.noDataInfo);
		}
		return jsonResultNoPage(list,ConstSessionName.successQueryInfo);
	}
	
	/**
	 * 新增分类
	 * @param data json字符串
	 * @return
	 */
	@RequestMapping(value="/save" ,method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String save(String data){
		Classify classify= JSONUtil.JSONToObect(data, Classify.class);
		classify.setClassifyid(UUIDUtil.generate());
		int i = classifyService.insertRecord(classify);
		if(i==1){
			return jsonResultNoPage(classify,ConstSessionName.successInsertInfo);
		}
		return jsonResultWithMsg("Server Error",ConstSessionName.failureInsertInfo);
	}
	
	
}
