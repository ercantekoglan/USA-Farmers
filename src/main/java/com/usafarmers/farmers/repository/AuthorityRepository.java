package com.usafarmers.farmers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usafarmers.farmers.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{

}
