package com.Project.InfluentiaSupport.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ticketsolutions")
public class TicketSolutions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="resolvedbyusername")
	private String resolvedByUserName;
	
	@Column(name="resolvedon")
	private Date resolvedOn;
	
	@Column(name="resolutiondetails")
	private String resolutionDetails;
	
	@Column(name="supportticketid")
	private int supportTicketId;

	
	public TicketSolutions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
