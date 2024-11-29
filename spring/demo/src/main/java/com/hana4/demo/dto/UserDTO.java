package com.hana4.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "age")
@EqualsAndHashCode
@Builder
public class UserDTO {
	private Long id;

	private String name;

	private short age;

	// @Singular("user")
	// private List<User> list;
	// builder().id(0).name(xx).user(hong).user(kim).list()
}
