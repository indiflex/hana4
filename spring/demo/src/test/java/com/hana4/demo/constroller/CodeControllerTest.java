package com.hana4.demo.constroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

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

	private final List<CodeDTO> sampleCodes = new ArrayList<>();

	@BeforeAll
	void BeforeAll() {
		System.out.println("CodeControllerTest.BeforeAll - -");
		for (int i = 0; i < 2; i++) {
			CodeDTO dto = new CodeDTO("Code" + i);
			sampleCodes.add(dto);
		}
	}

	@Test
	void createCodeTest() throws Exception {
		final String url = "/codes";

		for (CodeDTO dto : sampleCodes) {
			String reqBody = objectMapper.writeValueAsString(dto);

			final ResultActions result = mockMvc.perform(
				post(url).content(reqBody));

			result.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.codeName").value(dto.getCodeName()))
				.andDo(print());
		}
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
