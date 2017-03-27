package com.sl.nicefish.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.nicefish.dao.UserMapper;
import com.sl.nicefish.pojo.User;
import com.sl.nicefish.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserById(String userId) {
		return this.userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int insert(User user) {
		return this.userMapper.insertSelective(user);
	}

}
