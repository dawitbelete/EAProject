package edu.mum.domain;

import java.time.LocalDate;

public class ShipmentInfo {
	
	String guide;
	
	int shipmentdays;
	
	int reference;
	
	LocalDate fromDate;
	
	LocalDate toDate;
	
	String clientCompany;
	
	String addresee;
	
	String address;

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}

	public int getShipmentdays() {
		return shipmentdays;
	}

	public void setShipmentdays(int shipmentdays) {
		this.shipmentdays = shipmentdays;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public String getClientCompany() {
		return clientCompany;
	}

	public void setClientCompany(String clientCompany) {
		this.clientCompany = clientCompany;
	}

	public String getAddresee() {
		return addresee;
	}

	public void setAddresee(String addresee) {
		this.addresee = addresee;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}
}
