package com.hana4.demo.repository;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.data.domain.Sort.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.hana4.demo.entity.Post;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// @SpringBootTest
public class PostRepositoryTest {
	@Autowired
	private PostRepository repository;

	// @Autowired
	// EntityManager em;

	private final static LocalDateTime dateTime = LocalDateTime.of(LocalDate.of(2024, 12, 6), LocalTime.of(12, 0));

	private final static String WRITER = "세종대왕11";

	@Test
	void findBySomeColumnsTest() {
		List<Object[]> someColumns = repository.findBySomeColumns(WRITER);
		someColumns.forEach(objs -> System.out.println(objs[0] + ", " + objs[1] + "," + objs[2]));
		someColumns.forEach(objs -> {
			assertThat(objs[1]).isEqualTo(WRITER);
			assertThat((LocalDateTime)objs[2]).isBefore(dateTime);
		});
	}

	@Test
	void findByOldWriterTest() {
		List<Post> posts = repository.findByOldWriter(WRITER, dateTime);
		posts.forEach(System.out::println);
		assertThat(posts.stream().allMatch(post ->
			post.getWriter().equals(WRITER) &&
				(post.getCreatedate().isBefore(dateTime) || post.getCreatedate().isEqual(dateTime))
		)).isTrue();
	}

	@Test
	void findByTitleLikeTest() {
		final int countPerPage = 3;
		final String searchStr = "title%";
		long cnt = (long)Math.ceil((double)repository.countByTitleLike(searchStr) / (double)countPerPage);

		Sort sort = Sort.by(Order.asc("writer"), Order.desc("id"));
		Page<Post> posts = repository.findByTitleLike(searchStr, PageRequest.of(0, countPerPage, sort));
		System.out.println("totalPage = " + posts.getTotalPages());
		System.out.println("posts = " + posts.getContent());
		assertThat(posts.getTotalPages()).isEqualTo(cnt);
		posts.forEach(System.out::println);
	}

	@Test
	void findByTitleStartsWithTest() {
		List<Post> posts = repository.findByTitleStartsWith("title");
		List<Post> posts2 = repository.findByTitleStartingWith("title");
		System.out.println("posts = " + posts);
		System.out.println("posts2 = " + posts2);
		assertThat(posts.stream().allMatch(post -> post.getTitle().toLowerCase().startsWith("title"))).isTrue();
	}

	@Test
	void findByWriterTest() {
		List<Post> byWriter = repository.findByWriter(WRITER);
		System.out.println("byWriter = " + byWriter);
		assertThat(byWriter.stream().allMatch(post -> post.getWriter().equals(WRITER))).isTrue();

		Sort sort = Sort.by(Sort.Order.desc("id"));
		List<Post> byWriterSort = repository.findByWriter(WRITER, sort);

		byWriterSort.forEach(System.out::println);
	}

	@Test
	void countCretedateTest() {
		long cnt = repository.countByCreatedateLessThanEqual(dateTime);
		System.out.println("repocnt = " + repository.count());
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
		System.out.println("repocnt = " + repository.count());
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
