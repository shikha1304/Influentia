package com.Project.InfluentiaSupport.Interface;

import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;

public interface UpdateTicketsInt {
	public void updateTicketByRes(int ticketid) throws ResourceNotFoundException;
}
