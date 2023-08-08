package com.Project.InfluentiaSupport.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TicketResolutionDTO {

	private String resolvedByUserName;
	private String resolutionDetails;
	private int supportTicketId;
}
