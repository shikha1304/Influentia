package com.Project.InfluentiaSupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;
import com.Project.InfluentiaSupport.Interface.UpdateTicketsInt;
import com.Project.InfluentiaSupport.Repo.SupportTicketsRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CloseTicket implements UpdateTicketsInt{
	@Autowired
	private SupportTicketsRepo supportTicketsRepo;
	
//	public String updateTicketByRes(int ticketid) {
//		
//	}
	@Override
	public void updateTicketByRes(int ticketid) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		SupportTickets s = supportTicketsRepo.findById(ticketid).orElseThrow(()-> new ResourceNotFoundException("No Ticket with id" + ticketid + " is open"));
		s.setTicketStatus("Close");
		//return "Saved";
	}
}
