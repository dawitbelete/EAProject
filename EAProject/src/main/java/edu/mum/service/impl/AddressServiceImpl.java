package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.AddressDao;
import edu.mum.domain.Address;
import edu.mum.service.AddressService;

@Service
@Transactional 
public class AddressServiceImpl implements AddressService {
	
 	@Autowired
	private AddressDao memberDao;

    public void save( Address address) {  		
		memberDao.save(address);
	}
	
    public Address update( Address address) {  		
		return memberDao.update(address);
	}
	
	public List<Address> findAll() {
		return (List<Address>)memberDao.findAll();
	}
	
 	public Address findOne(Long id) {
		return memberDao.findOne(id);
	}

	public void delete(Long id) {
		memberDao.delete(id);
		
	}


	
 
}
