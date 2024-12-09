package com.hana4.demo.dto;

import com.hana4.demo.entity.SubCode;

public class SubCodeMapper {
	public static SubCodeDTO toDTO(SubCode subCode) {
		return SubCodeDTO.builder()
			.id(subCode.getId())
			.value(subCode.getValue())
			.code(CodeMapper.toDTO(subCode.getCode()))
			.build();
	}

	public static SubCode toEntity(SubCodeDTO dto) {
		return new SubCode(dto.getId(), dto.getValue(), CodeMapper.toEntity(dto.getCode()));
	}
}
