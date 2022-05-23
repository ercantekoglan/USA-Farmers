package com.usafarmers.farmers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usafarmers.farmers.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
