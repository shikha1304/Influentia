package com.project.Influentia.Repo;

import org.springframework.data.repository.CrudRepository;

import com.project.Influentia.Entity.UserSubscription;

public interface UserRepoUserSubscriptions extends CrudRepository<UserSubscription,Integer> {

	UserSubscription getByUsername(String username);

}
