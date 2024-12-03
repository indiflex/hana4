package com.hana4.demo.constroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hana4.demo.dto.UserDTO;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ApiControllerTest {
	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	WebApplicationContext context;

	@BeforeAll
	static void beforeAll() {
		System.out.println("Before Allllllllllllllllllll");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("After Alllllllllllllllllllllll");
	}

	@BeforeEach
	void beforeEach() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	@DisplayName("/api/users - User list test")
	void getUserListTest() throws Exception {
		final String url = "/api/users";
		final ResultActions result = mockMvc.perform(
			get(url)
			// get(url).param("q", "")
		);

		List<UserDTO> list = Arrays.asList(
			new UserDTO(1L, "AA10", (short)10),
			new UserDTO(2L, "AA11", (short)11), new UserDTO(3L, "AA12", (short)12));

		String reqStr = objectMapper.writeValueAsString(list);
		System.out.println("reqStr = " + reqStr);

		result.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(content().json(reqStr));
	}

}
