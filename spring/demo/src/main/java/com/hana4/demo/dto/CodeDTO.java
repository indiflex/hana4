package com.hana4.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CodeDTO extends CodeBaseDTO {
	private int id;
	private String codeName;
	// private CodeInfo codeInfo;

	@JsonManagedReference
	private List<SubCodeDTO> subcodes;
	// private List<User> codeUsers = new ArrayList<>();

	public CodeDTO(String codeName) {
		this.codeName = codeName;
	}
}
