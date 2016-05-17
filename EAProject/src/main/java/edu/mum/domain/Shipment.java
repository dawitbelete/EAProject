package edu.mum.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Shipment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	Item item;

	@OneToOne(fetch = FetchType.EAGER)
	User user;
	
	@OneToOne(fetch = FetchType.EAGER)
	Address address;
	
	String guide;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
