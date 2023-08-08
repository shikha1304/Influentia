package com.project.Influentia.Repo;

import org.springframework.data.repository.CrudRepository;

import com.project.Influentia.Entity.SubscriptionPlans;
import com.project.Influentia.Entity.UserSubscription;

public interface UserRepoSubscriptionPlans extends CrudRepository<SubscriptionPlans,Integer>{
	
	UserSubscription save(UserSubscription u);	

}
