package com.hana4.demo.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hana4.demo.entity.Code;
import com.hana4.demo.entity.CodeInfo;
import com.hana4.demo.entity.SubCode;

// @DataJpaTest
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class CodeRepositoryTest {
	@Autowired
	CodeRepository codeRepository;

	@Autowired
	CodeInfoRepository codeInfoRepository;

	@Autowired
	SubCodeRepository subCodeRepository;

	private final static int ID = 2;

	@Test
	void addCodeWithSubCode() {
		Code code = new Code();
		code.setCodeName("고가등급");
		codeRepository.save(code);

		SubCode subCode = new SubCode();
		subCode.setValue("S등급");
		subCode.setCode(code);
		subCodeRepository.save(subCode);

		System.out.println("subCode = " + subCode);
	}

	@Test
	void findCodeInfoTest() {
		Optional<CodeInfo> optionalCodeInfo = codeInfoRepository.findById(ID);
		CodeInfo codeInfo = optionalCodeInfo.orElseThrow();
		System.out.println("codeInfo = " + codeInfo);
	}

	@Test
	void findCodeTest() {
		Optional<Code> optionalCode = codeRepository.findById(ID);
		// assertThat(optionalCode.isPresent()).isTrue();
		// Code code = optionalCode.get();
		Code code = optionalCode.orElseThrow();
		System.out.println("code = " + code);
	}

	@Test
	void addCodeTest() {
		Code code = new Code();
		code.setCodeName("지점타입");
		Code savedCode = codeRepository.save(code);
		System.out.println("savedCode = " + savedCode);

		CodeInfo codeInfo = new CodeInfo();
		codeInfo.setInfo("전국의 지점 모든 타입");
		codeInfo.setCode(code);
		CodeInfo savedCodeInfo = codeInfoRepository.save(codeInfo);
		System.out.println("savedCodeInfo = " + savedCodeInfo);
	}
}
