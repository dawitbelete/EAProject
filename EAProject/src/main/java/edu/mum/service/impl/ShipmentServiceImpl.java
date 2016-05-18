package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.ShipmentDao;
import edu.mum.domain.Shipment;
import edu.mum.service.ShipmentService;

@Service
@Transactional 
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	ShipmentDao shipmentDao;
	
	@Override
	public void save(Shipment t) {
		shipmentDao.save(t);
	}

	@Override
	public Shipment update(Shipment t) {
		return shipmentDao.update(t);
	}

	@Override
	public List<Shipment> findAll() {
		return shipmentDao.findAll();
	}

	@Override
	public Shipment findOne(Long id) {
		return shipmentDao.findOne(id);
	}

	@Override
	public void delete(Long id) {
		shipmentDao.delete(id);
	}

}
