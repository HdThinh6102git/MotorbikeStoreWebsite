package com.MotorbikeStore.model;

import java.sql.Timestamp;

public class paymentModel {
	private int paymentId; 
	private int cusId;
	private int aMotorId; 
	private Timestamp dateBuy; 
	private Timestamp datePrepaid;
	private float moneyPrepaid;
	private float price; 
	private String paymentMethod;
	private String status;
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	public int getaMotorId() {
		return aMotorId;
	}
	public void setaMotorId(int aMotorId) {
		this.aMotorId = aMotorId;
	}
	
	public Timestamp getDateBuy() {
		return dateBuy;
	}
	public void setDateBuy(Timestamp dateBuy) {
		this.dateBuy = dateBuy;
	}
	
	public Timestamp getDatePrepaid() {
		return datePrepaid;
	}
	public void setDatePrepaid(Timestamp datePrepaid) {
		this.datePrepaid = datePrepaid;
	}
	
	public float getMoneyPrepaid() {
		return moneyPrepaid;
	}
	public void setMoneyPrepaid(float moneyPrepaid) {
		this.moneyPrepaid = moneyPrepaid;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	
	
}
