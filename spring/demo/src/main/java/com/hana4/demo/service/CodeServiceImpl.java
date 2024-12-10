package com.hana4.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.hana4.demo.dto.CodeDTO;
import com.hana4.demo.dto.CodeMapper;
import com.hana4.demo.dto.SubCodeDTO;
import com.hana4.demo.dto.SubCodeMapper;
import com.hana4.demo.entity.Code;
import com.hana4.demo.entity.SubCode;
import com.hana4.demo.repository.CodeRepository;
import com.hana4.demo.repository.SubCodeRepository;

@Service
public class CodeServiceImpl implements CodeService {
	private final CodeRepository repository;
	private final SubCodeRepository subCodeRepository;

	public CodeServiceImpl(CodeRepository repository, SubCodeRepository subCodeRepository) {
		this.repository = repository;
		this.subCodeRepository = subCodeRepository;
	}

	@Override
	public CodeDTO addCode(CodeDTO dto) {
		Code code = CodeMapper.toEntity(dto);
		if (Objects.isNull(dto) || Objects.isNull(code)) {
			return null;
		}

		repository.save(code);
		for (SubCode subCode : code.getSubcodes()) {
			subCode.setCode(code);
			subCodeRepository.save(subCode);
		}

		return CodeMapper.toDTO(code);
	}

	@Override
	public CodeDTO getCode(int id) {
		return CodeMapper.toDTO(repository.findById(id).orElseThrow());
	}

	@Override
	public CodeDTO findByName(String codeName) {
		return CodeMapper.toDTO(repository.findByCodeName(codeName).orElseThrow());
	}

	@Override
	public List<CodeDTO> getCodes() {
		return repository.findAll().stream()
			.map(CodeMapper::toDTO).toList();
	}

	@Override
	public List<CodeDTO> getCodesHaveSubCodes() {
		return repository.findBySubcodesIsNotEmpty().stream().map(CodeMapper::toDTO).toList();
	}

	@Override
	public CodeDTO modifyCode(CodeDTO dto) {
		Code code = repository.findById(dto.getId()).orElseThrow();
		code.setCodeName(dto.getCodeName());
		return CodeMapper.toDTO(repository.save(code));
	}

	@Override
	public long removeCode(int id) {
		repository.deleteById(id);
		// return repository.count();
		return 1L;
	}

	@Override
	public SubCodeDTO addSubCode(SubCodeDTO subCodeDTO) {
		return SubCodeMapper.toDTO(subCodeRepository.save(SubCodeMapper.toEntity(subCodeDTO)));
	}

	@Override
	public List<SubCodeDTO> getSubCodes(int codeId) {
		Code code = repository.findById(codeId).orElseThrow();
		return code.getSubcodes().stream().map(SubCodeMapper::toDTO).toList();
	}

	@Override
	public SubCodeDTO modifySubCode(SubCodeDTO dto) {
		SubCode subCode = subCodeRepository.findById(dto.getId()).orElseThrow();
		subCode.setValue(dto.getValue());
		subCodeRepository.save(subCode);
		return SubCodeMapper.toDTO(subCode);
	}

	@Override
	public Long removeSubCode(long subCodeId) {
		SubCode subCode = subCodeRepository.findById(subCodeId).orElseThrow();
		Code code = repository.findById(subCode.getCode().getId()).orElseThrow();

		final boolean didRemove = code.getSubcodes().remove(subCode);
		// subCode.setCode(null);

		subCodeRepository.delete(subCode);
		// repository.save(code);

		return didRemove ? 1L : 0L;
	}

}
