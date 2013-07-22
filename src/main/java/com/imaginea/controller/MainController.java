package com.imaginea.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String helloWorld(ModelMap model, Principal principal) {
		System.out.println("in helloWorld");

		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security Custom Form example");
		return "hello";
	}
}