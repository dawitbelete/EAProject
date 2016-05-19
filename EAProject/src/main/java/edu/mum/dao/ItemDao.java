package edu.mum.dao;

import java.math.BigDecimal;
import java.util.List;

import edu.mum.domain.Item;

public interface ItemDao extends GenericDao<Item> {
      
	public List<Item> findBySellerOrBuyer(Long sellerId,Long buyerId);
	public List<Item> findByName(String name, BigDecimal initialPrice);
	public List<Item> findByName(String name, BigDecimal initialPrice, BigDecimal initialPriceMax, String category);

}
