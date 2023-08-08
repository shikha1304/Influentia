package com.project.Influentia.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Influentia.Entity.SubscriptionPlans;
import com.project.Influentia.Entity.UserSubscription;
import com.project.Influentia.Repo.UserRepoSubscriptionPlans;
import com.project.Influentia.Repo.UserRepoUserSubscriptions;


@RestController
@RequestMapping(path="/api/subscriptions")
public class MainControl {
	@Autowired
	private UserRepoSubscriptionPlans userRepoSubscriptionPlans;
	@Autowired
	private UserRepoUserSubscriptions userRepoUserSubscriptions;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/plan")
	public @ResponseBody Iterable<SubscriptionPlans> getAllPlan()
	{
		return userRepoSubscriptionPlans.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/purchase")
	public UserSubscription addnewSubscription(@RequestBody UserSubscription u) {
		return userRepoSubscriptionPlans.save(u);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/plan/{username}")
	public @ResponseBody UserSubscription getAllPlansByUsername(@PathVariable String username){
		return userRepoUserSubscriptions.getByUsername(username);
	}
	
}
