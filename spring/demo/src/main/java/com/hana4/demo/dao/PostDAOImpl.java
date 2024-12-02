package com.hana4.demo.dao;

import java.util.List;

import com.hana4.demo.dto.PostDTO;
import com.hana4.demo.entity.Post;
import com.hana4.demo.repository.PostRepository;

public class PostDAOImpl implements PostDAO {
	private PostRepository repository;

	public PostDAOImpl(PostRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<PostDTO> findAll() {
		List<Post> all = repository.findAll();
	}

	@Override
	public PostDTO insert(Post post) {
		return null;
	}

	@Override
	public PostDTO findById(String id) {
		return null;
	}

	@Override
	public PostDTO update(PostDTO post) {
		return null;
	}

	@Override
	public PostDTO delete(String id) {
		return null;
	}
}
