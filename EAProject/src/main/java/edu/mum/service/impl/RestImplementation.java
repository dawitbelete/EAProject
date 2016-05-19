package edu.mum.service.impl;

import java.io.IOException;
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

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import edu.mum.domain.CreditCard;
import edu.mum.service.RestService;

@Service
public class RestImplementation implements RestService {

	@Override
	public boolean verifyCard(CreditCard creditCard)
	{
		
		
		String cardnumber=creditCard.getNumber();
		if(cardnumber=="")
		{	
			return false;	
		}
		
		
		String cardexpmonth=creditCard.getExpMonth();
		String cardexpyear=creditCard.getExpYear();
		
		System.out.println(cardnumber+cardexpmonth+cardexpyear);
		
		
		final String BASE_URI="http://localhost:8989/card/"+cardnumber;
		
		Client client=ClientBuilder.newClient();
		WebTarget target=client.target(BASE_URI);
		
		System.out.println(target.request(MediaType.APPLICATION_JSON_VALUE).get(String.class));
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			CreditCard creditCard2=mapper.readValue(target.request(MediaType.APPLICATION_JSON_VALUE).get(String.class), CreditCard.class);			
			if(creditCard.getExpMonth().equals(creditCard2.getExpMonth()) && creditCard.getExpYear().equals(creditCard2.getExpYear()))
			{	
				return true;
			}
		
		} catch (JsonParseException e) 
		{
			
			e.printStackTrace();
		} catch (JsonMappingException e)
		{
			
			e.printStackTrace();
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		
		return false;
	}

}
