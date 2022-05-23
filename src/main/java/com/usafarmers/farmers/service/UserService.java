package com.usafarmers.farmers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.usafarmers.farmers.domain.Address;
import com.usafarmers.farmers.domain.Authority;
import com.usafarmers.farmers.domain.User;
import com.usafarmers.farmers.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	public User saveUser(User user) {
		String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		Address address = new Address();
		Authority authority = new Authority();

		//only for demonstration - create an "admin" with admin username
		if (user.getUsername().equals("admin") ) {
			user.setUserProduct("Cherry");
			user.setPassword(encodedPassword);
			user.setUserProduct("No Information");
			address.setAddressLine1("123 Fake St");
			address.setAddressLine2("K205");
			address.setCity("Midland");
			address.setState("TX");
			address.setZipCode("79751");
			address.setUser(user);
			user.setAddress(address);

			authority.setAuthority("ROLE_ADMIN");
			user.getAuthorities().add(authority);
			authority.setUser(user);
			
		}else {

		authority.setAuthority("ROLE_USER");
		user.getAuthorities().add(authority);
		authority.setUser(user);

		address.setAddressLine1("No Information");
		address.setAddressLine2("No Information");
		address.setCity("No Information");
		address.setState("No Information");
		address.setZipCode("No Information");
		address.setUser(user);
		user.setAddress(address);
		user.setPassword(encodedPassword);
		user.setUserProduct("No Information");
		}
		return userRepo.save(user);
	}

	public User findById(Long userId) {
		Optional<User> findById = userRepo.findById(userId);
		return findById.orElse(null);

	}

	public void updateUser(User loggedInUser) {
		String encodedPassword = new BCryptPasswordEncoder().encode(loggedInUser.getPassword());
		loggedInUser.setPassword(encodedPassword);
		userRepo.save(loggedInUser);
	}

	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	public List<User> findAll() {
		List<User> findAll = userRepo.findAll();
		return findAll;
	}

	public void deleteUser(Long userId) {
		userRepo.deleteById(userId);
		
	}



}
