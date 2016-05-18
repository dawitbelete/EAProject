package edu.mum.domain;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne(fetch = FetchType.EAGER)
	Item item;

	@OneToOne(fetch = FetchType.EAGER)
	User user;

	@Valid
	@OneToOne(fetch = FetchType.EAGER)
	Address address;

	int maxShippingDays = 5;

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

	public ShipmentInfo getShipmentInfo() {
		ShipmentInfo shippingfo = new ShipmentInfo();
		shippingfo.setAddresee(this.getUser().getFirstName() + " " + this.getUser().getLastName());
		shippingfo.setAddress(this.getAddress().getStreet() + "," + this.getAddress().getZipcode() + ","
				+ this.getAddress().getCity());
		shippingfo.setClientCompany("GoodFellas Shop");
		shippingfo.setReference(getReference(1000, 5000));
		shippingfo.setShipmentdays(5);
		shippingfo.setFromDate(LocalDate.now());
		shippingfo.setEmailAdressee(this.getUser().getEmail());
		shippingfo.setItem(this.getItem().getName());
		return shippingfo;
	}

	private static int getReference(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).findFirst().getAsInt();
	}

	public int getMaxShippingDays() {
		return maxShippingDays;
	}

	public void setMaxShippingDays(int maxShippingDays) {
		this.maxShippingDays = maxShippingDays;
	}

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}
}
