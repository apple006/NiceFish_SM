package com.sl.nicefish.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sl.nicefish.pojo.User;
import com.sl.nicefish.service.IUserService;
import com.sl.nicefish.util.UUIDUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring-mybatis.xml"})
public class UserTest {
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void test0(){
		
		User u = userService.getUserById("3235464e-17d5-4364-a7dc-fce64542decc");
		System.out.println(u.getUserName());
	}
	
	@Test
	public void test1(){
		User u = new User();
		u.setUserId(UUIDUtil.generate());
		u.setUserName("zhangfei");
		u.setNickName("xiaozhang");
		u.setPassword("123456");
		u.setNickName("张翼德");
		u.setRealName("张飞");
		u.setCellPhone("110120");
		System.out.println(userService.insert(u));
	}
	
	@Test
	public void test2(){
		List<User> list = new ArrayList<User>();
		list = userService.getList();
		System.out.println(list.size());
	}
}
