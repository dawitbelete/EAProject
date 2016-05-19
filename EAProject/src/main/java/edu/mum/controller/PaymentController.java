package edu.mum.controller;



import java.io.IOException;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;





import edu.mum.domain.CreditCard;
import edu.mum.domain.Item;
import edu.mum.domain.Shipment;
import edu.mum.domain.User;
import edu.mum.service.RestService;

@Controller
public class PaymentController
{
	
	@Autowired
	private RestService restService;
	private static final String BASE_URI="http://localhost:8787/customers/1234567890123456";
	@RequestMapping("/payment")
	public String startPayment(@ModelAttribute("item") Item newItem,HttpSession session,Model model)
	{
	   
		model.addAttribute("name",newItem);
		User user=(User) session.getAttribute("user");
		System.out.println(user.toString());
		return "itemPaymentDetails";
	}
	
	
	@RequestMapping("/billing")
	public String billingDetails(@ModelAttribute("creditcard") CreditCard creditCards)
	{
		
		return "billing";
	}
	
	///checkBillingInfo
	@RequestMapping("/checkBillingInfo")
	public String checkbillingDetails(@ModelAttribute("creditcard")  CreditCard creditCard, HttpSession session,Model model)
	{
		
		
		try {
			User user=(User) session.getAttribute("user");
			creditCard.setOwner(user.getEmail());
			
			if(restService.verifyCard(creditCard))
			{
				Item item =(Item)session.getAttribute("sitem");
				User buyer =(User)session.getAttribute("user");
				item.setBuyer(buyer);
		 		Shipment shipment = new Shipment();
				shipment.setItem(item);
				shipment.setUser(buyer);
				
				model.addAttribute("newShipment", shipment);
				return "shipment";
			}
			else{
				return "redirect:billing";
			}
			
		}
		 catch (Exception e)
		{
			System.out.println("Error  null pointerrrrrrrrrrrrrrrrrrrrrrrrr");
			return "redirect:billing";
		}	
	}
	
	

}
