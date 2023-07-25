package com.Project.InfluentiaSupport.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubscriptionPlanDTO {
	private int planId;
	private String Name;
	private int pricePerMonth;
}
