package com.sl.nicefish.dao;

import java.util.List;

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
    
    /**
     * 根据激活码查询用户
     * @param code
     * @return
     */
    User getByCode(String code);
    
    /**
     * 查询所有用户
     * @return
     */
    List<User> getList();
    
    /**
     * 通过用户名查找
     * @param userName
     * @return
     */
    User getByUserName(String userName);
}