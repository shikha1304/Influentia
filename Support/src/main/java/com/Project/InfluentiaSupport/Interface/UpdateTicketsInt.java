package com.Project.InfluentiaSupport.Interface;

import com.Project.InfluentiaSupport.DTO.TicketResolutionDTO;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;

public interface UpdateTicketsInt {
	public void updateTicketResolution(TicketResolutionDTO ticketResolutionDTO);
	public void closeTicketById(int ticketid) throws ResourceNotFoundException;
}
