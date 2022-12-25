package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.Comment;
import com.blog.Post;

@Repository
public class PostDao {

	@Autowired
	private SessionFactory factory;

	@Transactional
	public List<Post> showPosts() {
		
		Session session = factory.getCurrentSession();
		
		List<Post> posts = ((org.hibernate.Session) session).createQuery("SELECT a FROM Post a", Post.class).getResultList(); 
		
		return posts;
	}
	
	@Transactional
	public void insertPost(Post post) {
		
		Session session = factory.getCurrentSession();
		
		session.saveOrUpdate(post);
		
	}
	
	@Transactional
	public Post viewPost(int id) {
		
		Session session = factory.getCurrentSession();
		
		 return session.get(Post.class, id);
	}
	
	@Transactional
	public Post editPost(int id) {
		Session session = factory.getCurrentSession();
		
		return session.get(Post.class, id);
	}
	
	@Transactional
	public void deletePost(int id) {
		
		Session session = factory.getCurrentSession();
		
		Post post = session.get(Post.class, id);
		
		session.remove(post);
	}
	
	@Transactional
	public void addComment(Comment newComment, int id) {
		
		Session session = factory.getCurrentSession();
		
		Post post = session.get(Post.class, id);
		
		newComment.setPost(post);
		
		post.getComment().add(newComment);
		
		session.saveOrUpdate(post);
	}
	
	@Transactional
	public Comment editComment(int id) {
		
		Session session = factory.getCurrentSession();
		
		return session.get(Comment.class, id);		
	}
}
