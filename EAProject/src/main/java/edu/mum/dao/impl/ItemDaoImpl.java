package edu.mum.dao.impl;

 

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	
	@Override
	/*	public Item findByName(String name) {
			// TODO Auto-generated method stub
			Query query = entityManager.createQuery("select i from Item i  where i.name =:name");
			return (Item) query.setParameter("name", name).getSingleResult();			
		    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		    // Typed query - expected results are of the type Item
			CriteriaQuery<Item> query = criteriaBuilder.createQuery(Item.class);
			// From part of the clause
			Root<Item> memberRoot = query.from(Item.class);
			// The Select
			query.select(memberRoot);
			// Where
			query.where(criteriaBuilder.equal(memberRoot.get("name"),  name) );
			return (Item)  entityManager.createQuery( query ).getSingleResult();
		}*/	
		
		public List<Item> findByName(String name, BigDecimal initialPrice, BigDecimal initialPriceMax, String category) {
		    CriteriaBuilder qb = entityManager.getCriteriaBuilder();
		    CriteriaQuery query = qb.createQuery();
		    Root<Item> itemRoot = query.from(Item.class);
		    //Constructing list of parameters
		    List<Predicate> predicates = new ArrayList<Predicate>();
		    //Adding predicates in case of parameter not being null
		    if ((name != null) && (!(name.isEmpty()))) {
		        predicates.add(
		                qb.equal(itemRoot.get("name"), name));
		        	//	(Predicate) query.where(qb.equal(itemRoot.get("name"),  name) ));
		    }
		    
		    if ((category != null) && (!(category.isEmpty()))) {
		        predicates.add(
		                qb.equal(itemRoot.get("category"), category));
		        	//	(Predicate) query.where(qb.equal(itemRoot.get("name"),  name) ));
		    }
		    if (initialPrice != null) {
		        predicates.add(
		                qb.greaterThan(itemRoot.get("initialPrice"), initialPrice));
		    }
		    if (initialPriceMax != null) {
		        predicates.add(
		                qb.lessThan(itemRoot.get("initialPrice"), initialPriceMax));
		    }
		    //query itself
		    query.select(itemRoot)
		            .where(predicates.toArray(new Predicate[]{}));
		    //execute query and do something with result
		    List<Item> resultList = (List<Item>)  entityManager.createQuery( query ).getResultList();
		    return resultList;
		}

	@Override
	public List<Item> findByName(String name, BigDecimal initialPrice) {
		// TODO Auto-generated method stub
		return null;
	}

 }