package com.Project.InfluentiaSupport.Interface;

import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;

public interface GetAllOpenTicketsInt{
	public Iterable<SupportTickets> viewAllNewTickets() throws ResourceNotFoundException;
	
}
