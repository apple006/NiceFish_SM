package com.sl.nicefish.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sl.nicefish.dao.PostMapper;
import com.sl.nicefish.pojo.Post;
import com.sl.nicefish.service.IPostService;

@Service("postService")
class PostServcieImpl implements IPostService {

	@Autowired
	private PostMapper postMapper;
	
	
	@Override
	public List<Post> getList() {
		// TODO Auto-generated method stub
		return null;
//		return postMapper.getList();
	}

	@Override
	public Post getById(String id) {
		// TODO Auto-generated method stub
		return postMapper.selectByPrimaryKey(id);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return postMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Post post) {
		// TODO Auto-generated method stub
		return postMapper.updateByPrimaryKeySelective(post);
	}

	@Override
	public int insert(Post post) {
		// TODO Auto-generated method stub
		return postMapper.insertSelective(post);
	}

	@Override
	public int batchDelete(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
//		return postMapper.batchDeleteByPrimaryKeys(ids);
	}

}
