package com.cognizant.spring.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.spring.web.dao.Offer;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showHome(Model model)
	{		
		return "home";
	}
	
	@RequestMapping("/test")
	public String showtest(Model model,@RequestParam("id") String id)
	{
		System.out.println("Id from Request Param :"+ id);
		return "home";
	}

}
