package com.csm.Repository;

import com.csm.Model.TransitPass;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransitPassRepository extends JpaRepository<TransitPass, Integer> {
	@Query(value = "FROM TransitPass tp")
	public List<TransitPass> getAllTransitPass();
	
}
