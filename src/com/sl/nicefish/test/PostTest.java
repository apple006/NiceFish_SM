package com.sl.nicefish.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
		p.setPostid(UUIDUtil.generate());
		p.setNickname("张翼德");
		p.setPosttitle(title);
		p.setPostcontent(content);
		p.setCreatetime(new Date());
		p.setStatus(1);
		p.setUserid("8d2a7444767f4051a0628b02e45b3e79");
		p.setIsoriginal(1);
		p.setUsername("zhangfei");
		p.setLikedtimes(100);
		p.setReadtimes(99);
		p.setLastmodifytime(new Date());
		p.setEnablecomment(1000);
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
		System.out.println(postService.getList());
	}
	
}
