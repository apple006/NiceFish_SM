package com.sl.nicefish.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sl.nicefish.pojo.Classify;
import com.sl.nicefish.service.IClassifyService;
import com.sl.nicefish.util.UUIDUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring-mybatis.xml" })
public class ClassifyTest {

	@Autowired
	private IClassifyService classifyService;
	
	@Test
	public void testClassGetList(){
		List<Classify> list = classifyService.getList();
		System.out.println(list.isEmpty());
		System.out.println(list.size()==0);
		System.out.println(null==list || list.size()==0 );
	}
	
	@Test
	public void testInsert(){
		Classify classify = new Classify();
		classify.setClassifyid(UUIDUtil.generate());
		classify.setClassifyname("生活");
		classify.setClassifydesc("生活相关");
		System.out.println(classifyService.insertRecord(classify));
	}

}
