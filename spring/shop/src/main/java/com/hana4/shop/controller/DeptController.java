package com.hana4.shop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hana4.shop.dto.Dept;
import com.hana4.shop.service.DeptService;

@Controller
@RequestMapping("/depts")
public class DeptController {

	private final DeptService service;

	public DeptController(DeptService service) {
		this.service = service;
	}

	@GetMapping("")
	public String getList(Model model) {
		List<Dept> depts = service.getList();
		model.addAttribute("depts", depts);
		return "depts/list";
	}

	@GetMapping("/{id}")
	public String getDetail(@PathVariable Integer id, Model model) {
		Dept dept = service.find(id);
		List<Dept> depts = service.getList();
		
		model.addAttribute("dept", dept);
		model.addAttribute("depts", depts);

		return "depts/detail";
	}
}
