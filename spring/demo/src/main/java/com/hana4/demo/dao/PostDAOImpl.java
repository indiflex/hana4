package com.hana4.demo.dao;

import java.util.List;
import java.util.Optional;

import com.hana4.demo.dto.PostDTO;
import com.hana4.demo.dto.PostMapper;
import com.hana4.demo.entity.Post;
import com.hana4.demo.repository.PostRepository;

public class PostDAOImpl implements PostDAO {
	private final PostRepository repository;

	public PostDAOImpl(PostRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<PostDTO> findAll() {
		List<Post> posts = repository.findAll();
		return posts.stream().map(PostMapper::toDTO).toList();
	}

	@Override
	public PostDTO insert(PostDTO post) {
		Post savedPost = repository.save(PostMapper.toPost(post));
		return PostMapper.toDTO(savedPost);
	}

	@Override
	public PostDTO findById(String id) {
		Optional<Post> post = repository.findById(id);
		return post.map(PostMapper::toDTO).orElse(null);
	}

	@Override
	public PostDTO update(PostDTO post) {
		Optional<Post> foundPost = repository.findById(post.getId());
		if (foundPost.isPresent()) {
			return PostMapper.toDTO(repository.save(foundPost.get()));
		} else {
			throw new IllegalStateException("Post Not Found!");
		}
	}

	@Override
	public PostDTO delete(String id) {
		Optional<Post> foundPost = repository.findById(id);
		if (foundPost.isPresent()) {
			repository.delete(foundPost.get());
			return PostMapper.toDTO(foundPost.get());
		} else {
			throw new IllegalStateException("Post Not Found!");
		}
	}
}
