package com.MotorbikeStore.model;

import java.sql.Timestamp;

public class commentModel extends AbstractModel<commentModel> {
	private int quantity;
	private String userName;
	private int cmtId;
	private int aMotorId; 
	private int userId;
	private Timestamp datecmt;
	private String cmtDecs;
	public int getCmtId() {
		return cmtId;
	}
	public void setCmtId(int cmtId) {
		this.cmtId = cmtId;
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
	public Timestamp getDatecmt() {
		return datecmt;
	}
	public void setDatecmt(Timestamp datecmt) {
		this.datecmt = datecmt;
	}
	public String getCmtDecs() {
		return cmtDecs;
	}
	public void setCmtDecs(String cmtDecs) {
		this.cmtDecs = cmtDecs;
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
