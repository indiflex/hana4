package com.hana4.demo.dao;

import java.util.List;

import com.hana4.demo.dto.PostDTO;

public interface PostDAO {
	List<PostDTO> findAll();

	PostDTO insert(PostDTO post);

	PostDTO findById(String id);

	PostDTO update(PostDTO post);

	PostDTO delete(String id);
}
