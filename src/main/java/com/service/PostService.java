package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Comment;
import com.blog.Post;
import com.dao.PostDao;

@Service
public class PostService implements PostServiceInterface {
	
	@Autowired
	private PostDao postDao;
	
	@Override
	public List<Post> showPosts(){
		return postDao.showPosts();
	}

	@Override
	public void insertPost(Post post) {
		postDao.insertPost(post);
	}
	
	@Override
	public Post viewPost(int id) {
		return postDao.viewPost(id);
	}

	@Override
	public Post editPost(int id) {
		return postDao.editPost(id);
	}

	@Override
	public void deletePost(int id) {
		
		postDao.deletePost(id);
		
	}

	@Override
	public void addComment(Comment comment, int id) {
		
		postDao.addComment(comment,id);
		
	}

	@Override
	public Comment editComment(int id) {
		
		return postDao.editComment(id);
	}
	
	
	
}
