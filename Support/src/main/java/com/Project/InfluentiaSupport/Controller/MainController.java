package com.Project.InfluentiaSupport.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project.InfluentiaSupport.service.GetTicketsById;
import com.Project.InfluentiaSupport.service.GetTicketsByUserName;
import com.Project.InfluentiaSupport.service.UserService;
import com.Project.InfluentiaSupport.DTO.SupportTicketsDTO;
import com.Project.InfluentiaSupport.DTO.UserLoginDTO;
import com.Project.InfluentiaSupport.Entity.SupportTickets;
import com.Project.InfluentiaSupport.Entity.UserDetails;
import com.Project.InfluentiaSupport.Exception.InvalidCredentialException;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;
//import com.CtsProject.InfluentiaSupport.Repo.SupportTicketsRepo;
import com.Project.InfluentiaSupport.service.CloseTicket;
import com.Project.InfluentiaSupport.service.CreateNewTickets;
import com.Project.InfluentiaSupport.service.GetAllOpenTickets;

@RestController
@RequestMapping("/api/tickets")
public class MainController {
	@Autowired
	private GetTicketsByUserName getTicketsByUserName;
    
	/*
	@Autowired
	private SupportTicketsRepo supportTicketsRepo;
	
	//Getall
	@GetMapping("/all")
	public @ResponseBody Iterable<SupportTickets> getAllTickets(){
		return supportTicketsRepo.findAll();
	}
	*/
	
	//Return a ticket by UserName
	@CrossOrigin
	@GetMapping("/name/{userName}")
	public @ResponseBody Iterable<SupportTickets> getTicketsByUserName(@PathVariable(value="userName") String raisedByUserName) throws ResourceNotFoundException{
		return getTicketsByUserName.getAllTicketsByUserName(raisedByUserName);
	}
	
	
	@Autowired
	private GetTicketsById getTicketsById;
	
	//Return a ticket by TicketId
	@CrossOrigin
	@GetMapping("/id/{id}")
	public @ResponseBody SupportTickets getTicketById(@PathVariable(value="id") int ticketId) throws ResourceNotFoundException{
		return getTicketsById.getTicketByTicketId(ticketId);
	}
	
	@Autowired
	private CreateNewTickets addNewTicket;
	
	/*
	@GetMapping("/planname/{username}")
	public @ResponseBody String getResponse(@PathVariable String username) {
		return addNewTicket.getPlanName(username);
	}
	*/
	
	
	//Add a new Ticket
	@CrossOrigin
	@PostMapping("/new")
	public String addNew(@RequestBody SupportTicketsDTO supportTicketsDTO) throws ResourceNotFoundException, InvalidCredentialException{
			return addNewTicket.addNewTicket(supportTicketsDTO);
	}
	
	@Autowired
	private GetAllOpenTickets getAllOpenTickets;
	
	//Return Subscription Plan
	 @CrossOrigin
	@GetMapping("/view/list-new")
	public Iterable<SupportTickets> viewAllNew() throws ResourceNotFoundException{
		return getAllOpenTickets.viewAllNewTickets();
	}
	
	@Autowired
	private CloseTicket updateTicket;
	
	//Update ticket with Resolution
	@CrossOrigin
	@PutMapping("{ticketid}/resolve")
	public String updateTicketByResolution(@PathVariable int ticketid) throws ResourceNotFoundException{
		updateTicket.updateTicketByRes(ticketid);
		return "Ticket with Ticket Id " + ticketid + " is closed successfully";
	}
	

	@Autowired
	private UserService userService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/registration")
	public UserDetails registrationUser(@RequestBody UserDetails user) throws Exception {
	        String temp=user.getEmail();
	        if(temp!=null && !"".equals(temp)) {
	            UserDetails userObj=userService.fetchByEmail(temp);
	            if(userObj!=null) {
	                throw new Exception("user already exists");
	            }
	        }

	        UserDetails userobj=null;
	        userobj=userService.saveUser(user);
	        return userobj;

	    }

	    @CrossOrigin(origins = "http://localhost:4200")
	    @PostMapping("/login")
	    public String loginUser(@RequestBody UserLoginDTO user) throws Exception {
	        String tempEmailId=user.getEmail();
	        String tempPass=user.getPassword();
	        UserDetails userobj=null;

	        if(tempEmailId!=null && tempPass !=null) {
	            userobj=userService.fetchByEmailandPassword(tempEmailId, tempPass);
	        }

	        if(userobj==null) {
	            throw new Exception("User does not Exist");
	        }

	        return userobj.getUserName();

	    }

	    
	
}

