package com.imaginea.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.imaginea.model.EmployeeDetails;
import com.imaginea.model.LeaveApplication;
import com.imaginea.services.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String helloWorld(ModelMap model, Principal principal) {
		System.out.println("in helloWorld");

		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security Custom Form example");
		return "hello";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model, Principal principal) {
		System.out.println("in index");
		EmployeeDetails employeeDetails = mainService
				.getEmployeeDetailsForUserName(principal.getName());
		model.addAttribute("name", employeeDetails.getFirstName());
		return "index";
	}

	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public String apply(@RequestParam String from, @RequestParam String to,
			Principal principal) {
		System.out.println("in apply");
		System.out.println("principal.getName() : " + principal.getName());
		
		EmployeeDetails employeeDetails = mainService.getEmployeeDetailsForUserName(principal.getName());
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");

		LeaveApplication leave = new LeaveApplication();

		leave.setFrom(from);
		leave.setTo(to);
		leave.setEmployeeID(employeeDetails.getId());
		
		mainService.addLeave(leave);
		return "index";
	}

}