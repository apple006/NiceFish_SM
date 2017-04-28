package com.sl.nicefish.dao;

import com.sl.nicefish.pojo.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(String commentid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String commentid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}