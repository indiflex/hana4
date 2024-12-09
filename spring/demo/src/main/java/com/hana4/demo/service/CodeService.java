package com.hana4.demo.service;

import java.util.List;

import com.hana4.demo.dto.CodeDTO;

public interface CodeService {
	public CodeDTO addCode(CodeDTO dto);

	public CodeDTO getCode(int id);

	public List<CodeDTO> getCodes();

	public CodeDTO modifyCode(CodeDTO dto);

	public long removeCode(int id);
}
