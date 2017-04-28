package com.sl.nicefish.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sl.nicefish.pojo.User;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //List<User> getList();
    
   // User getByUserName(String userName);
    
   // User getByCode(String code);
}