package com.Project.InfluentiaSupport.Interface;

import com.Project.InfluentiaSupport.DTO.SupportTicketsDTO;
import com.Project.InfluentiaSupport.Exception.InvalidCredentialException;
import com.Project.InfluentiaSupport.Exception.ResourceNotFoundException;


public interface AddNewTicketsInt {
	public String getPlanName(String userName);
	public String addNewTicket(SupportTicketsDTO suportTicketsDTO) throws ResourceNotFoundException, InvalidCredentialException;
}
