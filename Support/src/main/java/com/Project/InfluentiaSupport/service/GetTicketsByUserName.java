package com.Project.InfluentiaSupport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;
import com.Project.InfluentiaSupport.Interface.GetTicketsByUserNameInt;
import com.Project.InfluentiaSupport.Repo.SupportTicketsRepo;

@Service
public class GetTicketsByUserName implements GetTicketsByUserNameInt{
	@Autowired
	private SupportTicketsRepo supportTicketsRepo;
	
	@Override
	public @ResponseBody Iterable<SupportTickets> getAllTicketsByUserName(@PathVariable String raisedByUserName) throws ResourceNotFoundException{
		List<SupportTickets> list = supportTicketsRepo.findByRaisedByUserName(raisedByUserName);
		
		if(list.isEmpty())
			throw new ResourceNotFoundException("There is no Ticket created by " + raisedByUserName);
		
		return list;
	}
}
