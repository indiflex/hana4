package com.hana4.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hana4.demo.dao.ApiDAO;
import com.hana4.demo.domain.User;
import com.hana4.demo.dto.UserDTO;

@Service
public class ApiServiceImpl implements ApiService {
	private final ApiDAO dao;

	public ApiServiceImpl(ApiDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<UserDTO> getUsers() {
		List<User> users = dao.selectAll();

	}

	@Override
	public UserDTO getUser(Long id) {
		Optional<User> ouser = dao.select(id);
		if (ouser.isPresent()) {
			User user = ouser.get();
			UserDTO dto = new UserDTO(user.getId(), user.getName(), user.getAge());
		}
		return null;
	}

	@Override
	public UserDTO addUser(String name, short age) {
		return null;
	}

	@Override
	public UserDTO modifyUser(UserDTO user) throws Exception {
		return null;
	}

	@Override
	public UserDTO removeUser(Long id) throws Exception {
		return null;
	}
}
