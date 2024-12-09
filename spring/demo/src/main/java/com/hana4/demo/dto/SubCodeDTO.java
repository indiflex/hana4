package com.hana4.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class SubCodeDTO {
	private long id;
	private String value;
	private CodeDTO code;
}
