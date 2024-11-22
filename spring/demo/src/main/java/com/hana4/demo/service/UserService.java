package com.hana4.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hana4.demo.domain.User;
import com.hana4.demo.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public List<User> getList() {
		return repository.findAll();
	}

	public Long regist(User user) {
		repository.findByName(user.getName()).ifPresent(u -> {
			throw new IllegalStateException("Duplicate name!");
		});
		return repository.addUser(user);
	}

	public Optional<User> getUser(Long id) {
		return repository.findById(id);
	}
}
