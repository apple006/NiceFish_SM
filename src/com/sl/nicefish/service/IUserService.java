package com.sl.nicefish.service;


import com.sl.nicefish.pojo.User;

public interface IUserService {
	
	 User getUserById(String userId);
	 int insert (User user);
}
