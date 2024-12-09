package com.hana4.demo.constroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hana4.demo.dto.CodeDTO;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@AutoConfigureMockMvc
public class CodeControllerTest {
	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	private final List<CodeDTO> sampleCode = new ArrayList<>();

	void BeforeAll() {
		for (int i = 0; i < 2; i++) {
			CodeDTO dto = new CodeDTO("Code" + i);
			sampleCode.add(dto);
		}
	}

	@Test
	void createCodeTest() {
		final String url = "/codes";

		mockMvc.perform(post(url)).andExpect();
	}

	@Test
	void codeListTest() {
	}

	// @Autowired
	// WebApplicationContext context;

	// @AfterAll
	// void afterAll(@Autowired JpaUserRepository repository) {
	// 	System.out.println("After Alllllllllllllllllllllll");
	// 	repository.destroy();
	// }

}
