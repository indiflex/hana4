package com.hana4.demo.dto;

import java.util.List;
import java.util.Objects;

import com.hana4.demo.entity.Code;
import com.hana4.demo.entity.SubCode;

public class CodeMapper {
	public static CodeDTO toDTO(Code code) {
		if (Objects.isNull(code)) {
			return null;
		}

		CodeDTO dto = CodeDTO.builder()
			.id(code.getId())
			.codeName(code.getCodeName())
			.createAt(code.getCreateAt())
			.updateAt(code.getUpdateAt())
			.build();

		dto.setSubcodes(code.getSubcodes().stream().map(
			scode -> SubCodeMapper.toDTO(scode, dto)).toList());

		return dto;
	}

	public static Code toEntity(CodeDTO dto) {
		if (Objects.isNull(dto)) {
			return null;
		}
		Code code = new Code();
		code.setId(dto.getId());
		code.setCodeName(dto.getCodeName());
		if (!Objects.isNull(dto.getSubcodes())) {
			List<SubCode> subCodes = dto.getSubcodes()
				.stream()
				.map(scode
					-> SubCodeMapper.toEntity(scode, code))
				.toList();
			code.setSubcodes(subCodes);
		}

		return code;
	}
}
