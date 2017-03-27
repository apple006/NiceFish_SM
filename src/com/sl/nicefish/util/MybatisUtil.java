package com.sl.nicefish.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * mybatis 工具类
 * @author ZhangJing
 *
 */
public class MybatisUtil {
	private MybatisUtil(){}
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocale = new ThreadLocal<SqlSession>();
    //为SqlSessionFactory对象设置值
    static{
            try {
                    Reader reader = Resources.getResourceAsReader("mybatis.xml");
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }
    //获取SqlSession对象
    public static SqlSession getSqlSession(){
            SqlSession sqlSession = threadLocale.get();
            if(sqlSession == null){
                    sqlSession = sqlSessionFactory.openSession();
                    threadLocale.set(sqlSession);
            }
            return sqlSession;
    }
    //关闭SqlSession对象
    public static void closeSqlSession(){
            SqlSession sqlSession = threadLocale.get();
            if(sqlSession != null){
                    sqlSession.close();
                    threadLocale.remove();
                    sqlSession = null;
            }
    }
    public static void main(String[] args) {
    	SqlSession s= MybatisUtil.getSqlSession();
    	System.out.println(s);
	}
	
}
