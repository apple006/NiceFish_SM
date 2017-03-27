package com.sl.nicefish.dao;

import org.springframework.stereotype.Repository;

import com.sl.nicefish.pojo.User;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}