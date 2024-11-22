package com.hana4.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hana4.demo.domain.User;
import com.hana4.demo.service.UserService;

@Controller
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping("/users")
	@ResponseBody
	public List<User> getUsers() {
		return service.getList();
	}

	@PostMapping("/users")
	@ResponseBody
	public User regist(@RequestBody User user) {
		System.out.println("user = " + user);
		return user;
	}
}
