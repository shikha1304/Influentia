package com.Project.InfluentiaSupport.DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSubscriptionDTO {
	public UserSubscriptionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
private String username;

 

    

    private SubscriptionPlanDTO planid;

    

    

    private Date subscriptionStartDate;

    

    

    private Date subscriptionEndDate;

    

    

    private int amountPaid;

    

    

    private String paymentMode;

    

    

    private String subscriptionstatus;
}
