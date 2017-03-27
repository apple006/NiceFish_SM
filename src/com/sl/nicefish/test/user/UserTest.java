package com.sl.nicefish.test.user;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sl.nicefish.pojo.User;
import com.sl.nicefish.service.IUserService;

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
		u.setUserId(UUID.randomUUID().toString());
		u.setUserName("zhaoyun");
		u.setNickName("xiaozhao");
		u.setPassword("1231245");
		u.setNickName("战神赵子龙");
		u.setRealName("赵云");
		u.setCellPhone("1234567889");
		System.out.println(userService.insert(u));
	}
}
