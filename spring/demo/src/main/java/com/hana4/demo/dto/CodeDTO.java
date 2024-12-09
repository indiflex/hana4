package com.hana4.demo.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class CodeDTO extends CodeBaseDTO {
	private int id;
	private String codeName;
	// private CodeInfo codeInfo;
	private List<SubCodeDTO> subcodes;
	// private List<User> codeUsers = new ArrayList<>();

	public CodeDTO(String codeName) {
		this.codeName = codeName;
	}
}
