package com.Project.InfluentiaSupport.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.InfluentiaSupport.Entity.SubscriptionPlanSLAs;

public interface SubscriptionPlanSLAsRepo extends JpaRepository<SubscriptionPlanSLAs, Integer>{
	
	SubscriptionPlanSLAs findByPlanName(String planName);
}
