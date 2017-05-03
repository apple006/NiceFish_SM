package com.sl.nicefish.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sl.nicefish.pojo.Post;

@Repository
public interface PostMapper {
    int deleteByPrimaryKey(String postid);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(String postid);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKeyWithBLOBs(Post record);

    int updateByPrimaryKey(Post record);
    
    List<Post> getList();
    //int batchDeleteByPrimaryKeys(String[] ids);
}