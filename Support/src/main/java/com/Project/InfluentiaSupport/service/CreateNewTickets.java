package com.Project.InfluentiaSupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.Calendar;

import com.Project.InfluentiaSupport.FeignClients;
import com.Project.InfluentiaSupport.DTO.UserSubscriptionDTO;
import com.Project.InfluentiaSupport.DTO.SupportTicketsDTO;
import com.Project.InfluentiaSupport.Interface.AddNewTicketsInt;
import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Exception.InvalidCredentialException;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;
import com.Project.InfluentiaSupport.Repo.SubscriptionPlanSLAsRepo;
import com.Project.InfluentiaSupport.Repo.SupportTicketsRepo;

@Service
public class CreateNewTickets implements AddNewTicketsInt {

	@Autowired
	private FeignClients feignClient;
	
	@Autowired
	private SupportTicketsRepo supportTicketsRepo;

	
	@Autowired
	private SubscriptionPlanSLAsRepo subscriptionPlanSLAsRepo;
	
    @Override
	public String getPlanName(String userName) {
		Iterable<UserSubscriptionDTO> u = feignClient.getAllPlansByUsername(userName);
		String planName="";
		for(UserSubscriptionDTO e:u) {
			planName=e.getPlanid().getName();
		}
		return planName;
	}
	
    @Override
	public String addNewTicket(@RequestBody SupportTicketsDTO suportTicketsDTO) throws ResourceNotFoundException, InvalidCredentialException{
		//System.out.println("Hello");
    	
    	SupportTickets supportTickets = new SupportTickets();
    	
    	//mapping dto to entity
    	supportTickets.setRaisedByUserName(suportTicketsDTO.getRaisedByUserName());
    	supportTickets.setTicketDetails(suportTicketsDTO.getTicketDetails());
    	supportTickets.setTicketSummary(suportTicketsDTO.getTicketSummary());
    	String ticketType = suportTicketsDTO.getTicketType();
    	
    	if(!(ticketType.equalsIgnoreCase("Billing") || ticketType.equalsIgnoreCase("Subscription") || ticketType.equalsIgnoreCase("Post Management") || ticketType.equalsIgnoreCase("Others")) )
    		throw new InvalidCredentialException("Ticket Type is invalid");
    			
		//DateFormat dform = new SimpleDateFormat("dd/MM/yy");
		Date today = new Date();
		supportTickets.setCreatedOn(today);
		Date createdOn = supportTickets.getCreatedOn();
		
		// Getting the PlanName
		String planName = getPlanName(suportTicketsDTO.getRaisedByUserName());
		if(planName.equals(null))
			throw new ResourceNotFoundException(suportTicketsDTO.getRaisedByUserName()+" is not a subscriber of Influentia");
		//System.out.println(s);
		
		//Use feign client to retrieve the subscription Plan for user
		//SubscriptionPlanSLAs s1 = subscriptionPlanSLAsRepo.findByPlanName(s);
		//System.out.println(s1.getExpectedSLAInDays());
		
		//Constraint
		//System.out.println(supportTickets.getTicketType() + "     " + planName);
		if (planName.equalsIgnoreCase("Basic")) {
			
			if( ticketType.equalsIgnoreCase("Post Management"))
			return "The users with basic plan are not allowed to create the support tickets for PostManagement related queries.";
			
			//int count = supportTicketsRepo.findTicketsByDate(supportTickets.getRaisedByUserName());
			if(supportTicketsRepo.findTicketsByDate(supportTickets.getRaisedByUserName())>0) return "Sorry! You have already raised a ticket this week";
		}
		
		supportTickets.setTicketType(ticketType);
		
		int days =subscriptionPlanSLAsRepo.findByPlanName(planName).getExpectedSLAInDays();
		
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(createdOn);
		cal.add(Calendar.DATE, days);
		Date date = cal.getTime();
		supportTickets.setExpectedResolutionOn(date);
		
		supportTickets.setTicketStatus("Open");
		
		supportTicketsRepo.save(supportTickets);
		
		return "Added a new Ticket";
	}

}
