package com.hana4.demo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CodeBaseDTO {
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
}
