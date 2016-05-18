package edu.mum.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.domain.Category;
import edu.mum.domain.Item;
import edu.mum.service.CategoryService;
import edu.mum.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private CategoryService categoryService;

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Set.class, new CustomCollectionEditor(Set.class) {
			@Override
			protected Object convertElement(Object element) {
				String categoryId = (String) element;
				return categoryService.findOne(Long.valueOf(categoryId));
			}
		});
	}

	@RequestMapping({ "", "/all" })
	public String list(Model model) {
		model.addAttribute("items", itemService.findAll());
		return "items";
	}

	@RequestMapping("/item")
	public String getItemById(Model model, @RequestParam("id") Long id) {

		Item item = itemService.findOne(id);
		model.addAttribute("item", item);
		return "item";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewItemForm(Model model, @ModelAttribute("newItem") Item newItem) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categoriesList", categories);
		return "addItem";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewItemForm(@ModelAttribute("newItem") @Valid Item itemToBeAdded, BindingResult result) {
		if (result.hasErrors()) {
			return "addItem";
		}

		try {
			itemService.update(itemToBeAdded);
		} catch (Exception up) {
			System.out.println("Transaction Failed!!!");
			up.printStackTrace();
		}

		return "redirect:/items";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchItems(Model model, @RequestParam("itemId") String id, @RequestParam("itemName") String name) {

		if(!id.isEmpty()){
			System.out.println("id:"+id);
		}
		if(!name.isEmpty()){
			System.out.println("name:"+name);
		}
		
		return "items";
	}
}
