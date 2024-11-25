package com.hana4.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hana4.shop.dto.CustDTO;
import com.hana4.shop.service.MainService;

@Controller
public class MainController {

	private final MainService service;

	@Autowired
	public MainController(MainService service) {
		this.service = service;
	}

	@RequestMapping("/")
	public String mainpage(Model model) {
		model.addAttribute("version", "0.1.2");

		List<CustDTO> custs = service.getCusts();
		model.addAttribute("custs", custs);

		return "main";
	}
}
