package edu.mum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
public class HomeController {

 
	@RequestMapping({"/","/welcome"})
	public String welcome(Model model) {
		
		model.addAttribute("greeting", "Welcome to our Shop, GoodFella!!");
		model.addAttribute("tagline", "If we don&apos;t sell it, you won&apos;t need it!!");
		
		return "welcome";
	}
 
}
