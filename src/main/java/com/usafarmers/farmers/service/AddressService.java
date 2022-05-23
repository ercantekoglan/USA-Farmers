package com.usafarmers.farmers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usafarmers.farmers.domain.Address;
import com.usafarmers.farmers.domain.User;
import com.usafarmers.farmers.repository.AddressRepository;


@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepo;

	public Address updateAddress(User user) {
		user.getAddress().setUser(user);
		user.getAddress().setUserId(user.getUserId());
		return addressRepo.save(user.getAddress());

	}

}
