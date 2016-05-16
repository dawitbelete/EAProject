package edu.mum.dao.impl;

 

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.ItemDao;
import edu.mum.domain.Item;


@SuppressWarnings("unchecked")
@Repository
public class ItemDaoImpl extends GenericDaoImpl<Item> implements ItemDao {

	public ItemDaoImpl() {
		super.setDaoType(Item.class );
		}

	public List<Item> findBySellerOrBuyer(Long sellerId,Long buyerId) {
		Query query = entityManager.createQuery("select distinct i from Item i, User u  "
				+ "where (i.initialPrice >  22 and i.seller.id = :sellerId) "
				+                   "OR "
				+ "( u.id = :buyerId and i member of u.boughtItems and  i.initialPrice = i.reservePrice  )");
		return (List<Item>) query.setParameter("sellerId", sellerId).setParameter("buyerId", buyerId).getResultList();
			     

	}

 }