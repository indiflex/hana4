package com.hana4.demo.service;

import java.util.List;

import com.hana4.demo.dto.PostDTO;

public interface PostService {

	List<PostDTO> getPosts();

	PostDTO addPost(String title, String writer, String body);

	PostDTO getPost(String id);

	PostDTO modifyPost(PostDTO post);

	PostDTO removePost(String id);
}
