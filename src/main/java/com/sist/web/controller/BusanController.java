package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BusanController {
	private final String[] title= {"","명소","문화시설","축제","숙박","쇼핑","음식점"};
	
	
	@GetMapping("/busan")
	public String busan_list(@RequestParam(name="type",required = false)String type,Model model)
	{
		if(type==null)
			type="1";
		int i=Integer.parseInt(type);
		model.addAttribute("title", title[i]);
		model.addAttribute("busan_jsp", "../busan/busan_list.jsp");
		model.addAttribute("main_jsp", "../busan/busan_main.jsp");
		return "main/main";
	}
}
