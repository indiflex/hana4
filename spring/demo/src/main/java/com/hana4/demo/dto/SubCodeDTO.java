package com.hana4.demo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Builder
public class SubCodeDTO {
	private long id;
	private String value;

	@JsonBackReference
	private CodeDTO code;

	public SubCodeDTO(String value) {
		this.value = value;
	}

	public SubCodeDTO(String value, CodeDTO code) {
		this.value = value;
		this.code = code;
	}
}
