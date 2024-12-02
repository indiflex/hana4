package com.hana4.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hana4.demo.dao.PostDAO;
import com.hana4.demo.dto.PostDTO;
import com.hana4.demo.entity.Post;

@Service
public class PostServiceImpl implements PostService {

	private final PostDAO dao;

	public PostServiceImpl(PostDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<PostDTO> getPosts() {
		return dao.findAll();
	}

	@Override
	public PostDTO addPost(String title, String writer, String body) {
		Post post = new Post(title, writer, body);
		return dao.insert(post);
	}

	@Override
	public PostDTO getPost(String id) {
		return dao.findById(id);
	}

	@Override
	public PostDTO modifyPost(PostDTO post) {
		return dao.update(post);
	}

	@Override
	public PostDTO removePost(String id) {
		return dao.delete(id);
	}
}
