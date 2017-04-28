package com.sl.nicefish.test;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.apache.naming.factory.TransactionFactory;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.sl.nicefish.dao.UserMapper;
import com.sl.nicefish.pojo.User;
import com.sl.nicefish.util.MybatisUtil;

public class MybaisUtilTest {
	@Test
	public void test0(){
		
		SqlSession session = MybatisUtil.getSqlSession();
		try{
			UserMapper userMapper = session.getMapper(UserMapper.class);
			User u = new User();
			u.setUserId(UUID.randomUUID().toString());
			u.setUserName("zhangfei");
			u.setNickName("小飞飞");
			u.setPassword("892295834");
			
			u.setUserRealName("张飞");
			
			int i = userMapper.insertSelective(u);
			session.commit();
			System.out.println(i);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			MybatisUtil.closeSqlSession();
		}
		
		
		
	}
	
	/**
	 * jdbc 获取数据库连接
	 */
	@Test
	public void test1() {
		Properties pro = new Properties();
		try {
			FileInputStream fis = new FileInputStream("classpath:config/jdbc.properties");
			pro.load(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(pro.getProperty("jdbc.url"));
		Connection conn =null;
		
		//加载 jdbc 驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(pro.getProperty("jdbc.url"), pro.getProperty("jdbc.username"), pro.getProperty("jdbc.password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(conn);
		
	}
	
	
	
	
}
