package com.usafarmers.farmers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usafarmers.farmers.domain.Nutrients;

public interface NutrientRepository extends JpaRepository<Nutrients, Long>{

	@Query("select u from Nutrients u where nutrientname = :id")
	Nutrients findByName(String id);

}
