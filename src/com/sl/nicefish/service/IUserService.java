package com.sl.nicefish.service;


import java.util.List;

import com.sl.nicefish.pojo.User;

/**
 * 用户
 * @author ZhangJing
 *
 */
public interface IUserService {
	
	/**
	 * 通过id获取用户
	 * @param userId
	 * @return
	 */
	User getUserById(String userId);
	
	/**
	 * 通过激活码查找用户
	 * @param code
	 * @return
	 */
	User getUserByCode(String code);
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	int insert (User user);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> getList();
	
	/**
	 * 用户修改
	 * @param user
	 * @return
	 */
	int update(User user);
	
	/**
	 * 通过用户主键删除用户
	 * @param userId
	 * @return
	 */
	int delete(String userId);
	
}
