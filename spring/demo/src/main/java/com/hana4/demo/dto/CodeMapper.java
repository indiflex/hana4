package com.hana4.demo.dto;

import java.util.List;

import com.hana4.demo.entity.Code;
import com.hana4.demo.entity.SubCode;

public class CodeMapper {
	public static CodeDTO toDTO(Code code) {
		return CodeDTO.builder()
			.id(code.getId())
			.codeName(code.getCodeName())
			.subcodes(code.getSubcodes().stream().map(SubCodeMapper::toDTO).toList()).build();
	}

	public static Code toEntity(CodeDTO dto) {
		Code code = new Code();
		code.setId(dto.getId());
		
		code.setCodeName(dto.getCodeName());
		List<SubCode> subCodes = dto.getSubcodes().stream().map(SubCodeMapper::toEntity).toList();
		code.setSubcodes(subCodes);

		return code;
	}
}
