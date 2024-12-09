package com.hana4.demo.dto;

import java.util.List;
import java.util.Objects;

import com.hana4.demo.entity.Code;
import com.hana4.demo.entity.SubCode;

public class CodeMapper {
	public static CodeDTO toDTO(Code code) {
		System.out.println("code.getCreateAt() = " + code.getCreateAt());
		return CodeDTO.builder()
			.id(code.getId())
			.codeName(code.getCodeName())
			.createAt(code.getCreateAt())
			.updateAt(code.getUpdateAt())
			.subcodes(code.getSubcodes().stream().map(SubCodeMapper::toDTO).toList()).build();
	}

	public static Code toEntity(CodeDTO dto) {
		Code code = new Code();
		code.setId(dto.getId());
		code.setCodeName(dto.getCodeName());
		if (!Objects.isNull(dto.getSubcodes())) {
			List<SubCode> subCodes = dto.getSubcodes().stream().map(SubCodeMapper::toEntity).toList();
			code.setSubcodes(subCodes);
		}

		return code;
	}
}
