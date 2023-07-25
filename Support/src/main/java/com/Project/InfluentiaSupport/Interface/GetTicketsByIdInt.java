package com.Project.InfluentiaSupport.Interface;

import org.springframework.web.bind.annotation.PathVariable;

import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;

public interface GetTicketsByIdInt {
	public SupportTickets getTicketByTicketId(@PathVariable int ticketId) throws ResourceNotFoundException;
}
