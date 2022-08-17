package com.csm.Repository;

import com.csm.Model.Farmer;
import com.csm.Model.FarmerSell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface FarmerSellRepository extends JpaRepository<FarmerSell, Integer> {
	

	FarmerSell getFarmerSellByDateAndFarmer(Date date, Farmer farmer);
	
	@Query(value="FROM FarmerSell s")
	public List<FarmerSell> getAllSells(); 
}
