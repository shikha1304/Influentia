package com.Project.InfluentiaSupport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;
import com.Project.InfluentiaSupport.Interface.GetAllOpenTicketsInt;
import com.Project.InfluentiaSupport.Repo.SupportTicketsRepo;

@Service
public class GetAllOpenTickets implements GetAllOpenTicketsInt{

	@Autowired
	private SupportTicketsRepo supportTicketsRepo;
	
	@Override
	public @ResponseBody Iterable<SupportTickets> viewAllNewTickets() throws ResourceNotFoundException{
		List<SupportTickets> list = supportTicketsRepo.findByTicketStatus("Open");
		if(list.isEmpty())
			throw new ResourceNotFoundException("No Tickets are Open at the moment");
		
		return list;
	}
	
}
