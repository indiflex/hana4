package com.hana4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hana4.demo.entity.Post;

public interface PostRepository extends JpaRepository<Post, String> {
}
