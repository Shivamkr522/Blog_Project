package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.Comment;
import com.blog.Post;
import com.service.PostService;

@Controller
@RequestMapping("/")
public class PostController {
	
	@Autowired
	private PostService show;
	
	@RequestMapping(params = {})
	public String showTest(Model model) {
		
		List<Post> posts= show.showPosts();
		model.addAttribute("posts",posts);
		
		return "test";
	}
	 
	@RequestMapping("writePost")
	public String postPage(Model theModel) {
		
		theModel.addAttribute("post", new Post());
		
		return "home";
	}
	
	@RequestMapping("submitForm")
	public String postSubmit(@ModelAttribute("post") Post post) {
		
		show.insertPost(post);
		
		return "redirect:/";
	}
	
	@RequestMapping("editPost")
	public String updatePost(@RequestParam("id") String id, Model model) {
		
		model.addAttribute("post",show.editPost(Integer.parseInt(id)));
		
		return "home";
	}
	
	@RequestMapping("viewPost")
	public String viewStory(@RequestParam("id") String id,Model model) {
		
		model.addAttribute("post",show.viewPost(Integer.parseInt(id)));
		Comment comment = new Comment();
		model.addAttribute("commentnew",comment);
		return "viewPost";
	}
	
	@RequestMapping("deletePost")
	public String deletePost(@RequestParam("id") String id) {
		
		show.deletePost(Integer.parseInt(id));
		
		return "redirect:/";
	}
	
	@RequestMapping("addComment")
	public String addComment(@ModelAttribute("commentnew") Comment comment,@RequestParam("commentid") String id) {
		
		show.addComment(comment,Integer.parseInt(id));
		
		return "redirect:/viewPost"; 
	}
	
	@RequestMapping("editComment")
	public String editComment(@RequestParam("commentId") int id, Model model) {
		
		model.addAttribute("commentnew",show.editComment(id));
		
		return "redirect:/viewPost";
	}
}
