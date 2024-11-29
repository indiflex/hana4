package com.hana4.demo.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString(exclude = "age")
@EqualsAndHashCode
public class UserDTO {
	private Long id;
	private String name;
	private short age;
}
