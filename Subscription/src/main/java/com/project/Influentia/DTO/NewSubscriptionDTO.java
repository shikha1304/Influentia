package com.project.Influentia.DTO;

import java.sql.Date;

public class NewSubscriptionDTO {
	
	private String username;
	private int planid;
	private Date subscriptionStartDate;
	private Date subscriptionEndDate;
	private int amountPaid;
	private String paymentMode;
	private String subscriptionstatus;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPlanid() {
		return planid;
	}
	public void setPlanid(int planid) {
		this.planid = planid;
	}
	public Date getSubscriptionStartDate() {
		return subscriptionStartDate;
	}
	public void setSubscriptionStartDate(Date subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}
	public Date getSubscriptionEndDate() {
		return subscriptionEndDate;
	}
	public void setSubscriptionEndDate(Date subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}
	public int getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getSubscriptionstatus() {
		return subscriptionstatus;
	}
	public void setSubscriptionstatus(String subscriptionstatus) {
		this.subscriptionstatus = subscriptionstatus;
	}
	public NewSubscriptionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewSubscriptionDTO(String username, int planid, Date subscriptionStartDate, Date subscriptionEndDate,
			int amountPaid, String paymentMode, String subscriptionstatus) {
		super();
		this.username = username;
		this.planid = planid;
		this.subscriptionStartDate = subscriptionStartDate;
		this.subscriptionEndDate = subscriptionEndDate;
		this.amountPaid = amountPaid;
		this.paymentMode = paymentMode;
		this.subscriptionstatus = subscriptionstatus;
	}
	
	
}
