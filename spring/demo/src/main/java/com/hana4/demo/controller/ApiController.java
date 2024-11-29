package com.hana4.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hana4.demo.dto.UserDTO;

@RestController
@RequestMapping("/api")
public class ApiController {
	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		return service
	}
}
