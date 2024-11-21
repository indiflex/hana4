package com.hana4.demo.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.hana4.demo.domain.User;

public class UserRepositoryTest {

	final UserRepository repository = new VolatileUserRepository();

	@Test
	public void addUser() {
		User user = new User(0L, "Hong");
		Long newerId = repository.addUser(user);
		assertEquals(1, newerId);
	}

	@Test
	public void saveUser() {
		
	}
}
