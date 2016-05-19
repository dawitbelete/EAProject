package edu.mum.service;

import java.util.List;

import edu.mum.domain.Shipment;

public interface ShipmentService {

	public void save(Shipment shipment);

	public Shipment update(Shipment shipment);

	public List<Shipment> findAll();

	public Shipment findOne(Long id);

	public void delete(Long id);
	
	public void saveFull(Shipment shipment);
	
}
