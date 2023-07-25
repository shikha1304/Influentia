package com.Project.InfluentiaSupport.Entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="supporttickets")
public class SupportTickets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ticketid")
	private int ticketId;
	
	@Column(name="raisedbyusername")
	private String raisedByUserName;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="createdon")
	private Date createdOn;
	
	@Column(name="expectedresolutionon")
	private Date expectedResolutionOn;
	
	@Column(name="ticketsummary")
	private String ticketSummary;
	
	@Column(name="ticketdetails")
	private String ticketDetails;
	
	@Column(name="ticketstatus")
	private String ticketStatus;
	
	@Column(name="tickettype")
	private String ticketType;

	
	public SupportTickets() {
		super();
		// TODO Auto-generated constructor stub
	}

	}
