package com.Project.InfluentiaSupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import com.Project.InfluentiaSupport.DTO.TicketResolutionDTO;
import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Entity.TicketSolutions;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;
import com.Project.InfluentiaSupport.Interface.UpdateTicketsInt;
import com.Project.InfluentiaSupport.Repo.SupportTicketsRepo;
import com.Project.InfluentiaSupport.Repo.TicketSolutionsRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CloseTicket implements UpdateTicketsInt{
	@Autowired
	private SupportTicketsRepo supportTicketsRepo;
	
	@Autowired
	private TicketSolutionsRepo ticketSolutionsRepo;
//	public String updateTicketByRes(int ticketid) {
//		
//	}
	@Override
	public void updateTicketResolution(TicketResolutionDTO ticketResolutionDTO) {
		TicketSolutions ticketSolutions = new TicketSolutions();
		ticketSolutions.setResolvedByUserName(ticketResolutionDTO.getResolvedByUserName());
		ticketSolutions.setResolutionDetails(ticketResolutionDTO.getResolutionDetails());
		ticketSolutions.setSupportTicketId(ticketResolutionDTO.getSupportTicketId());
	
		Date today = new Date();
		ticketSolutions.setResolvedOn(today);
		
		ticketSolutionsRepo.save(ticketSolutions);
	}
	
	@Override
	public void closeTicketById(int ticketid) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		SupportTickets s = supportTicketsRepo.findById(ticketid).orElseThrow(()-> new ResourceNotFoundException("No Ticket with id" + ticketid + " is open"));
		s.setTicketStatus("Close");
		//return "Saved";
	}
}
