package com.hana4.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String mainpage(Model model) {
		model.addAttribute("version", "0.1.2");
		return "main";
	}
}
