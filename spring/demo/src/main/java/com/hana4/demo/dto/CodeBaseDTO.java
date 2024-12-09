package com.hana4.demo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class CodeBaseDTO {
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
}
