package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.domain.Item;
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
	public String getItemById(Model model, @RequestParam("id") Long id) {

		Item item = itemService.findOne(id);
		model.addAttribute("item", item);
		
		return "forward:payment";
	}
}
