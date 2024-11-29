package com.hana4.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hana4.demo.dto.UserDTO;

@Service
public class ApiServiceImpl implements ApiService {
	@Override
	public List<UserDTO> getUsers() {
		return List.of();
	}

	@Override
	public UserDTO getUser(Long id) {
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
