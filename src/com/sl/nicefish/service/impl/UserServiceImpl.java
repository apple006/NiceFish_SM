package com.sl.nicefish.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.nicefish.dao.UserMapper;
import com.sl.nicefish.pojo.User;
import com.sl.nicefish.service.IUserService;

@Service("userService")
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

	@Override
	public User getUserByCode(String code) {
		return this.userMapper.getByCode(code);
	}

	@Override
	public List<User> getList() {
		return this.userMapper.getList();
	}

	@Override
	public int update(User user) {
		return this.userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int delete(String userId) {
		return this.userMapper.deleteByPrimaryKey(userId);
	}

}
