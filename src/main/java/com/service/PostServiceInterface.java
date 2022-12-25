package com.service;

import java.util.List;

import com.blog.Comment;
import com.blog.Post;

public interface PostServiceInterface {
	
	public List<Post> showPosts();
	
	public void insertPost(Post post);
	
	public Post viewPost(int id);
	
	public Post editPost(int id);
	
	public void deletePost(int id);
	
	public void addComment(Comment comment, int id);
	
	public Comment editComment(int id);
}
