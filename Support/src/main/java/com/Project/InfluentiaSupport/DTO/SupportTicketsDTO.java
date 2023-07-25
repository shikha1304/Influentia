package com.Project.InfluentiaSupport.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupportTicketsDTO {
 
	private String raisedByUserName;
	private String ticketSummary;
	private String ticketDetails;
	private String ticketType;
}
