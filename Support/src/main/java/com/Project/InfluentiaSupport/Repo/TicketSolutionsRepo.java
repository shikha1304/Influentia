package com.Project.InfluentiaSupport.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.InfluentiaSupport.Entity.TicketSolutions;

public interface TicketSolutionsRepo extends JpaRepository<TicketSolutions, Integer>{
	TicketSolutions findBySupportTicketId(int supportTicketId);
}
