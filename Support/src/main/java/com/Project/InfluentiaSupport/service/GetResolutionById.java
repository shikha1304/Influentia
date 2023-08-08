package com.Project.InfluentiaSupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.InfluentiaSupport.Entity.TicketSolutions;
import com.Project.InfluentiaSupport.Repo.TicketSolutionsRepo;

@Service
public class GetResolutionById {

	@Autowired
	private TicketSolutionsRepo ticketSolutionsRepo;
	
	public TicketSolutions getTicketSolution(int supportTicketId) {
		return ticketSolutionsRepo.findBySupportTicketId(supportTicketId);
	}
}
