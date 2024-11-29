package com.hana4.demo.dao;

import java.util.List;
import java.util.Optional;

import com.hana4.demo.domain.User;
import com.hana4.demo.dto.UserDTO;
import com.hana4.demo.repository.ApiRepository;

public class ApiDAOImpl implements ApiDAO {

	private final ApiRepository repository;

	public ApiDAOImpl(ApiRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<User> selectAll() {
		return repository.findAll();
	}

	@Override
	public Optional<User> select(Long id) {
		return repository.findById(id);
	}

	@Override
	public User insert(String name, short age) {
		User user = new User(name, age);
		return repository.save(user);
	}

	@Override
	public User update(UserDTO user) throws Exception {
		Optional<User> pUser = repository.findById(user.getId());
		if (pUser.isPresent()) {
			return repository.save(pUser.get());
		} else {
			throw new IllegalStateException("User not Found!");
		}
	}

	@Override
	public User delete(Long id) throws Exception {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			repository.delete(user.get());
			return user.get();
		} else {
			throw new IllegalStateException("User not Found!");
		}
	}
}
