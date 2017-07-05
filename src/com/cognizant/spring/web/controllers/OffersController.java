package com.cognizant.spring.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.spring.web.dao.Offer;
import com.cognizant.spring.web.service.OffersService;

@Controller
public class OffersController {
	
	/*
	@RequestMapping("/")
	public String showHome(HttpSession session)
	{
		session.setAttribute("name", "Laxmikanth");
		return "home";
	}
	*/
	
	/*
	@RequestMapping("/")
	public ModelAndView showHome()
	{
		ModelAndView mv = new ModelAndView("home");
		Map<String, Object> model = mv.getModel();
		
		model.put("name", "ModelViewTest");
		
		return mv;
	}
	*/
	
	private OffersService offersService;
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	
	

	@RequestMapping("/showoffers")
	public String showOffers(Model model)
	{
		offersService.throwDataException();
		model.addAttribute("name", "<b>ModelTestAttrib</b>");
		List<Offer> offers = offersService.getCurrentOffers();
		
		model.addAttribute("offers", offers);
		return "showoffers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model)
	{
		model.addAttribute("offer",new Offer());
		return "createoffer";
	}
	
	@RequestMapping(value="/docreate",method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result)
	{	
		if(result.hasErrors())
		{
			System.out.println("Offer validation failed");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error: errors)
			{
				System.out.println(error.getDefaultMessage());
			}
			return "createoffer";
		}
		else
		{
			System.out.println("Offer validated successfully");
			offersService.createOffer(offer);
		}
		System.out.println(offer);
		return "offercreated";
	}

}
