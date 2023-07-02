package com.MotorbikeStore.model;

import java.sql.Timestamp;

public class reviewModel extends AbstractModel<reviewModel> {
	private int rv_id;
	private int aMotorId;
	private int userId;
	private Timestamp daterv;
	private String rvDesc;
	private String userName; 
	private int quantity;
	public int getRv_id() {
		return rv_id;
	}
	public void setRv_id(int rv_id) {
		this.rv_id = rv_id;
	}
	public int getaMotorId() {
		return aMotorId;
	}
	public void setaMotorId(int aMotorId) {
		this.aMotorId = aMotorId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Timestamp getDaterv() {
		return daterv;
	}
	public void setDaterv(Timestamp daterv) {
		this.daterv = daterv;
	}
	public String getRvDesc() {
		return rvDesc;
	}
	public void setRvDesc(String rvDesc) {
		this.rvDesc = rvDesc;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
