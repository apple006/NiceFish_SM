package com.sl.nicefish.service;

import java.util.List;

import com.sl.nicefish.pojo.Post;

public interface IPostService {
	
	/**
	 * 获取帖子列表
	 * @return
	 */
	List<Post> getList();
	
	/**
	 * 通过id 获取帖子
	 * @param id
	 * @return
	 */
	Post getById(String id );
	
	/**
	 * 通过id删除帖子
	 * @param id
	 */
	int delete(String id);
	
	/**
	 * 更新帖子
	 * @param post
	 * @return
	 */
	int update(Post post);
	
	/**
	 * 新增帖子
	 * @param post
	 * @return
	 */
	int insert(Post post);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	int batchDelete(String[] ids);
	
	
	
	
}
