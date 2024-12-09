package com.hana4.demo.service;

import java.util.List;

import com.hana4.demo.dto.CodeDTO;
import com.hana4.demo.dto.CodeMapper;
import com.hana4.demo.repository.CodeRepository;

public class CodeServiceImpl implements CodeService {
	private CodeRepository repository;

	@Override
	public CodeDTO addCode(CodeDTO dto) {
		return CodeMapper.toDTO(repository.save(CodeMapper.toEntity(dto)));
	}

	@Override
	public CodeDTO getCode(int id) {
		return CodeMapper.toDTO(repository.findById(id).orElseThrow());
	}

	@Override
	public List<CodeDTO> getCodes() {
		return repository.findAll().stream()
			.map(CodeMapper::toDTO).toList();
	}

	@Override
	public CodeDTO modifyCode(CodeDTO dto) {
		return CodeMapper.toDTO(repository.save(CodeMapper.toEntity(dto)));
	}

	@Override
	public long removeCode(int id) {
		repository.deleteById(id);
		return repository.count();
	}
}
