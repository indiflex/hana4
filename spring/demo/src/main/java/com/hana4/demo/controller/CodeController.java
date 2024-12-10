package com.hana4.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hana4.demo.dto.CodeDTO;
import com.hana4.demo.dto.SubCodeDTO;
import com.hana4.demo.service.CodeService;

@RestController
@RequestMapping("/codes")
public class CodeController {

	private final CodeService codeService;

	public CodeController(CodeService codeService) {
		this.codeService = codeService;
	}

	@GetMapping
	public List<CodeDTO> getCodes() {
		return codeService.getCodes();
	}

	@GetMapping("/{id}")
	public CodeDTO getCode(@PathVariable("id") int id) {
		return codeService.getCode(id);
	}

	@PostMapping
	public CodeDTO addCode(@RequestBody CodeDTO dto) {
		return codeService.addCode(dto);
	}

	@PatchMapping("/{id}")
	public CodeDTO modifyCode(@PathVariable("id") int id, @RequestBody CodeDTO dto) {
		dto.setId(id);
		return codeService.modifyCode(dto);
	}

	@DeleteMapping("/{id}")
	public Long removeCode(@PathVariable("id") int id) {
		return codeService.removeCode(id);
	}

	/**
	 * SubCode Area
	 */
	@PostMapping("/{id}/subcodes")
	public SubCodeDTO addSubCode(@PathVariable("id") int codeId, @RequestBody SubCodeDTO subCodeDTO) {
		CodeDTO codeDTO = codeService.getCode(codeId);
		subCodeDTO.setCode(codeDTO);
		return codeService.addSubCode(subCodeDTO);
	}

	@GetMapping("/{id}/subcodes")
	public List<SubCodeDTO> getSubCodes(@PathVariable("id") int codeId) {
		return codeService.getSubCodes(codeId);
	}

	@PatchMapping(value = {"/{id}/subcodes/{sid}", "/subcodes/{sid}"})
	public SubCodeDTO modifySubCode(@PathVariable("sid") long subCodeId, @RequestBody SubCodeDTO dto) {
		dto.setId(subCodeId);
		return codeService.modifySubCode(dto);
	}

	@DeleteMapping(value = {"/{id}/subcodes/{sid}", "/subcodes/{sid}"})
	public Long removeSubCode(@PathVariable("id") int codeId, @PathVariable("sid") long subCodeId) {
		return codeService.removeSubCode(subCodeId);
	}
}
