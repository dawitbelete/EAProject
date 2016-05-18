package edu.mum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.domain.User;
import edu.mum.domain.UserCredentials;
import edu.mum.service.UserCredentialsService;

@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	UserCredentialsService credentialsService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model) {
		
 		return "login";
	}
 
	
	@RequestMapping(value="/postLogin", method = RequestMethod.GET)
	public String PostLogin(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)){    
        	model.addAttribute("user", getPrincipal());
        	return "redirect:/welcome";
        }
 		
//
////		UserCredentials validCredentials = credentialsService.findByUserName(credentials.getUsername());
//// 
////		if (validCredentials == null)
////			return  "login";
// 
//		credentialsService.authenticate(credentials);
//		model.addAttribute("user", credentials.getUser());
 		return "redirect:/login";
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	//public String logout(Model model, SessionStatus status) {
	public String logoutPage (HttpServletRequest request, HttpServletResponse response, SessionStatus status)	{
	    status.setComplete();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
 		return "redirect:/welcome";
 	}
	
	private User getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        UserCredentials uc = credentialsService.findByUserName(userName);
        return uc.getUser();
    }
}
