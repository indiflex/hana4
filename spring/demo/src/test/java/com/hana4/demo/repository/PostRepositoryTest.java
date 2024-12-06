package com.hana4.demo.repository;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

	private final static LocalDateTime dateTime = LocalDateTime.of(LocalDate.of(2024, 12, 5), LocalTime.of(12, 0));

	@Test
	void countCretedateTest() {
		long cnt = repository.countByCreatedateLessThanEqual(dateTime);
		System.out.println("cnt = " + cnt);
		assertThat(cnt).isGreaterThan(0);
	}

	@Test
	void findCreatedateLessThanEqualTest() {
		long cnt = repository.countByCreatedateLessThanEqual(dateTime);
		List<Post> posts = repository.findByCreatedateLessThanEqual(dateTime);
		System.out.println("posts.size() + \":\" + repository.count() = " + posts.size() + ":" + repository.count());
		assertThat(posts.size()).isEqualTo(cnt);
	}

	// @Test
	// void findByAnythingTest() {
	// 	final LocalDate ldate = LocalDate.of(2024, 12, 3);
	// 	final LocalDateTime dateTime = LocalDateTime.of(ldate, LocalTime.of(9, 0));
	// 	List<Post> posts = repository.findByAnything("세종대왕11", dateTime);
	// 	System.out.println("posts = " + posts);
	// 	assertThat(posts.size()).isGreaterThan(0);
	// }

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
