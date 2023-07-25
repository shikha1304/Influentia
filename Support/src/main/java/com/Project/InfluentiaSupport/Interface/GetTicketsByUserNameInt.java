package com.Project.InfluentiaSupport.Interface;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;

public interface GetTicketsByUserNameInt {
	public @ResponseBody Iterable<SupportTickets> getAllTicketsByUserName(@PathVariable String raisedByUserName)  throws ResourceNotFoundException;
}
