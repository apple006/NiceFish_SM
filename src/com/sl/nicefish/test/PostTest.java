package com.sl.nicefish.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.sl.nicefish.pojo.Post;
import com.sl.nicefish.service.IPostService;
import com.sl.nicefish.util.UUIDUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring-mybatis.xml"})
public class PostTest {
	
	@Autowired
	private IPostService postService;
	
	public void insert(String title,String content){
		Post p = new Post();
		p.setPostId(UUIDUtil.generate());
		p.setNickname("张翼德");
		p.setPostTitle(title);
		p.setPostContent(content);
		p.setCreateTime(new Date());
		p.setStatus(1);
		p.setUserId("8d2a7444767f4051a0628b02e45b3e79");
		p.setIsOriginal(1);
		p.setUserName("zhangfei");
		p.setLikedTimes(100);
		p.setReadTimes(99);
		p.setLastModifyTime(new Date());
		p.setEnableComment(1000);
		int i = postService.insert(p);
		System.out.println(i);
	}
	
	@Test
	public void test0()  {
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(1000);
				insert("大战长坂坡"+i,"dsafsadfsdafsdafdsafsdafsdafsdafsda大战长坂坡"+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void test1(){
		System.out.println(JSONObject.toJSONString(postService.getList()));
	}
	
}