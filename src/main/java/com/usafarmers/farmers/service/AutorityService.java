package com.usafarmers.farmers.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usafarmers.farmers.domain.Authority;
import com.usafarmers.farmers.repository.AuthorityRepository;

@Service
public class AutorityService {

	@Autowired
	private AuthorityRepository authRepo;

	public Authority findById(Long userId) {
		Optional<Authority> findById = authRepo.findById(userId);
		return findById.orElse(null);
	}
}
