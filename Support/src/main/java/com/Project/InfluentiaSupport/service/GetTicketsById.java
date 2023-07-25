package com.Project.InfluentiaSupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;
import com.Project.InfluentiaSupport.Interface.GetTicketsByIdInt;
import com.Project.InfluentiaSupport.Repo.SupportTicketsRepo;

@Service
public class GetTicketsById implements GetTicketsByIdInt{

	@Autowired
	private SupportTicketsRepo supportTicketsRepo;
	
	@Override
	public @ResponseBody SupportTickets getTicketByTicketId(@PathVariable int ticketId) throws ResourceNotFoundException{
		return supportTicketsRepo.findById(ticketId).orElseThrow(()->new ResourceNotFoundException("No Ticket with Ticket Id " + ticketId + " exists"));
	}
}
