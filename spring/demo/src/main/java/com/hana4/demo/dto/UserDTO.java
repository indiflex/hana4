package com.hana4.demo.dto;

import java.util.List;

import com.hana4.demo.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString(exclude = "age")
@EqualsAndHashCode
@Builder
public class UserDTO {
	private Long id;

	private String name;

	private short age;

	@Singular("user")
	private List<User> list;

	public UserDTO(short age) {
		this.age = age;
	}
}
