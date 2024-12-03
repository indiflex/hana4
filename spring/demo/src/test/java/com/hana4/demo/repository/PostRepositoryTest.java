package com.hana4.demo.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hana4.demo.entity.Post;

import jakarta.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PostRepositoryTest {
	@Autowired
	private PostRepository repository;

	@Autowired
	EntityManager em;

	@Test
	void addPostTest() {
		List<Post> beforeList = repository.findAll();
		System.out.println("beforeList.size() = " + beforeList.size());

		String title = "title";
		Post post = new Post(title, "writer", "body");

		// Post savedPost = repository.save(post);
		Post savedPost = repository.save(post);
		System.out.println("savedPost = " + savedPost);

		assertThat(savedPost.getId()).isNotNull();
		assertThat(savedPost.getId()).matches("([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})");
		assertThat(savedPost.getTitle()).isEqualTo(title);
		assertThat(savedPost.getBody()).isEqualTo(post.getBody());
		// assertThat(savedPost.getWorkdate()).isNotNull();

		List<Post> afterList = repository.findAll();
		assertThat(afterList.size()).isGreaterThan(beforeList.size());
	}

}
