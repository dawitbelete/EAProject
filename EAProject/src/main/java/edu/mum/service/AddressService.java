package edu.mum.service;

import java.util.List;

import edu.mum.domain.Address;

public interface AddressService {

	public void save(Address address);

	public Address update(Address address);

	public List<Address> findAll();

	public Address findOne(Long id);

	public void delete(Long id);
}
