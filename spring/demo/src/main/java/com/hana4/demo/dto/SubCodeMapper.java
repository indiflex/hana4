package com.hana4.demo.dto;

import com.hana4.demo.entity.Code;
import com.hana4.demo.entity.SubCode;

public class SubCodeMapper {
	public static SubCodeDTO toDTO(SubCode subCode) {
		return toDTO(subCode, CodeMapper.toDTO(subCode.getCode()));
	}

	public static SubCodeDTO toDTO(SubCode subCode, CodeDTO codeDTO) {
		return SubCodeDTO.builder()
			.id(subCode.getId())
			.value(subCode.getValue())
			.code(codeDTO)
			.build();
	}

	public static SubCode toEntity(SubCodeDTO dto) {
		return toEntity(dto, CodeMapper.toEntity(dto.getCode()));
	}

	public static SubCode toEntity(SubCodeDTO dto, Code code) {
		return new SubCode(dto.getId(), dto.getValue(), code);
	}
}
