package com.hana4.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hana4.demo.dto.PostDTO;
import com.hana4.demo.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	private final PostService service;

	public PostController(PostService service) {
		this.service = service;
	}

	@GetMapping()
	public List<PostDTO> getPosts() {
		return service.getPosts();
	}

	@PostMapping()
	public PostDTO addPost(@RequestBody PostDTO post) {
		return service.addPost(post);
	}

	@GetMapping("/{id}")
	public PostDTO getPost(@PathVariable String id) {
		return service.getPost(id);
	}

	@PatchMapping("/{id}")
	public PostDTO updatePost(@PathVariable String id, @RequestBody PostDTO post) {
		return service.modifyPost(id);
	}

	@DeleteMapping("/{id}")
	public PostDTO removePost(@PathVariable String id) {
		return service.removePost(id);
	}
}
