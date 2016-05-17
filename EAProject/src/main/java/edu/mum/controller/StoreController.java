package edu.mum.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.domain.Item;
import edu.mum.domain.Shipment;
import edu.mum.domain.User;
import edu.mum.service.ItemService;

@Controller
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private ItemService itemService;
 
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
		
		Shipment shipment = new Shipment();
		
		shipment.setItem(item);
		shipment.setUser(buyer);
		model.addAttribute("newShipment", shipment);
		
		return "shipment";
	}
 	
 	
// 	@Autowired
// 	private CreditCardRemoteService creditService;
// 	
// 	@RequestMapping("/payment")
// 	public String getPaymentPage(@ModelAttribute("item") Item newItem, HttpSession session){
// 		User user = (User) session.getAttribute("user");
// 		
//		return "billing";
// 		
// 	}
// 	
// 	@RequestMapping("/processPayment")
// 	public String getPaymentPage(@ModelAttribute("creditData") CreditCard creditcard){
// 		//code
// 		//Call to the service
// 		creditService.send(creditCard);
// 		System.out.println("Success");
// 		
//		return "shipment";
// 		
// 	}
 	
}
