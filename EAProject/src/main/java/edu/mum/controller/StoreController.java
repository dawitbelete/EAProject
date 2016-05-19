package edu.mum.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.domain.Item;
import edu.mum.domain.Shipment;
import edu.mum.domain.User;
import edu.mum.service.ItemService;
import edu.mum.service.MessageSender;
import edu.mum.service.ShipmentService;

@Controller
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ShipmentService shipmentService;
	
	@Autowired
	MessageSender topicMessageSender;
 
 	@RequestMapping({"","/all"})
	public String list(Model model) {
		model.addAttribute("items", itemService.findAll());
		return "store";
	}
 	
 	@RequestMapping("/item")
	public String getItemById(Model model, @RequestParam("id") Long id, HttpSession session) {

		Item item = itemService.findOne(id);
		User buyer =(User) session.getAttribute("user");
		item.setBuyer(buyer);
		model.addAttribute("item", item);
		session.setAttribute("sitem", item);
		
		Shipment shipment = new Shipment();
		
		shipment.setItem(item);
		shipment.setUser(buyer);
		model.addAttribute("newShipment", shipment);
		
		return "forward:/payment";
	}
 	
 	@RequestMapping("/ship")
	public String sendOrder(Model model, @ModelAttribute("newShipment") @Valid Shipment shipment, BindingResult result, HttpSession session) {
 		Item item =(Item)session.getAttribute("sitem");
		User buyer =(User)session.getAttribute("user");
		item.setBuyer(buyer);
 		
		shipment.setItem(item);
		shipment.setUser(buyer);
		
		model.addAttribute("newShipment", shipment);
 		
 		if(result.hasErrors()) {
			return "shipment";
		}
 		
 		topicMessageSender.sendMessage(shipment.getShipmentInfo());
 		
 		shipmentService.saveFull(shipment);
 		
		return "success";
	}
 	
}
