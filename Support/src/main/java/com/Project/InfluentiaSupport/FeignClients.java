package com.Project.InfluentiaSupport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Project.InfluentiaSupport.DTO.UserSubscriptionDTO;



@org.springframework.cloud.openfeign.FeignClient(name = "Influentia", url = "http://localhost:3000")
public interface FeignClients {
	@GetMapping(path="/api/subscriptions/plan/{username}")
	Iterable <UserSubscriptionDTO> getAllPlansByUsername(@PathVariable String username);
}
