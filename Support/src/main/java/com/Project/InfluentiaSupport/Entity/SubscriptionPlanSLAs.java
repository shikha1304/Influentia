package com.Project.InfluentiaSupport.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="subscriptionplanslas")
public class SubscriptionPlanSLAs {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="planname")
	private String planName;
	
	@Column(name="expectedslaindays")
	private int expectedSLAInDays;

	public SubscriptionPlanSLAs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
