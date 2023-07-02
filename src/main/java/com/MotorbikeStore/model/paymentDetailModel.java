package com.MotorbikeStore.model;

import java.sql.Timestamp;

public class paymentDetailModel extends AbstractModel<paymentDetailModel>{
	
	private int paymentId;
	private String status;
	private String cusName;
	private String motorsName; 
	private String color;
	private Timestamp dateBuy; 
	private Timestamp datePrepaid;
	private float price; 
	private float moneyPrepaid; 
	private String paymentMethod;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getMotorsName() {
		return motorsName;
	}
	public void setMotorsName(String motorsName) {
		this.motorsName = motorsName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getMoneyPrepaid() {
		return moneyPrepaid;
	}
	public void setMoneyPrepaid(float moneyPrepaid) {
		this.moneyPrepaid = moneyPrepaid;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
