package com.sl.nicefish.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sl.nicefish.pojo.Post;

@Repository
public interface PostMapper {
    int deleteByPrimaryKey(String postId);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(String postId);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKeyWithBLOBs(Post record);

    int updateByPrimaryKey(Post record);
    
    /**
     * 查询帖子列表
     * @return
     */
    List<Post> getList();
    
    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDeleteByPrimaryKeys(String[] ids);
}