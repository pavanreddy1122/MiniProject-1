package com.MiniProject1.InsurenceReport.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MiniProject1.InsurenceReport.Entity.CitizenPlan;

public interface InsurenceRepository extends JpaRepository<CitizenPlan,Integer> {
	
	@Query("select distinct(c.planName) from CITIZEN_PLANS_INFO c")
	public List<String> getPlanName();
	
	@Query("select distinct(c.planStatus) from CITIZEN_PLANS_INFO c")
	public List<String> getPlanStatus();
	
	

}
