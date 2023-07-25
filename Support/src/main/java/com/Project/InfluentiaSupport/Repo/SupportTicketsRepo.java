package com.Project.InfluentiaSupport.Repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Project.InfluentiaSupport.Entity.SupportTickets;

public interface SupportTicketsRepo extends JpaRepository<SupportTickets, Integer>{
	List<SupportTickets> findByRaisedByUserName(String RaisedByUserName);
	//List<SupportTickets> findByTicketId(int ticketId);
	List<SupportTickets> findByTicketStatus(String ticketStatus);
	
	@Query("SELECT count(ticketId) FROM SupportTickets WHERE raisedByUserName=:name AND DATEDIFF(CURRENT_DATE, createdOn)<=7")
	Integer findTicketsByDate(@Param("name")String raisedByUserName);
}
