package edu.mum.service;

import java.util.List;

import edu.mum.domain.Item;
 
public interface ItemService {

	public void save(Item Item);
	public Item update(Item Item);
	public List<Item> findAll();
	 
	public List<Item> findBySellerOrBuyer(Long sellerId,Long buyerId);
	 
	public Item findOne(Long id);

}
