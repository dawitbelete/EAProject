package edu.mum.service;

import java.util.List;

import edu.mum.domain.Item;
 
public interface ItemService{

	public void save(Item item);

	public Item update(Item item);

	public List<Item> findAll();

	public Item findOne(Long id);

	public void delete(Long id);
	
	public List<Item> findBySellerOrBuyer(Long sellerId,Long buyerId);
	 

}
