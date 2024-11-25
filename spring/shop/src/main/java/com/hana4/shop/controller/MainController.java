package com.hana4.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String mainpage(Model model) {
		model.addAttribute("version", "0.1.2");

		Map<String, String> map = new HashMap<>();
		map.put("str1", "str1");
		map.put("str2", "str2");
		// model.addAttribute("map", map);
		model.addAttribute("keys", map.keySet());

		return "main";
	}
}
