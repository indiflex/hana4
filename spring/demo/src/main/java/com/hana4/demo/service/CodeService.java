package com.hana4.demo.service;

import java.util.List;

import com.hana4.demo.dto.CodeDTO;
import com.hana4.demo.dto.SubCodeDTO;

public interface CodeService {
	public CodeDTO addCode(CodeDTO dto);

	public CodeDTO getCode(int id);

	public CodeDTO findByName(String codeName);

	public List<CodeDTO> getCodes();

	List<CodeDTO> getCodesHaveSubCodes();

	public CodeDTO modifyCode(CodeDTO dto);

	public long removeCode(int id);

	SubCodeDTO addSubCode(SubCodeDTO subCodeDTO);

	List<SubCodeDTO> getSubCodes(int codeId);

}
