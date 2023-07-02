package com.MotorbikeStore.model;

import java.sql.Timestamp;

public class commentDetailModel extends AbstractModel<commentDetailModel>{
	private int cmtId;
	private String userName; 
	private String cmtDesc;
	private Timestamp dateCmt;
	private int aMotorId; 
	private String motorName;
	private String motorColor;
	
	public int getCmtId() {
		return cmtId;
	}
	public void setCmtId(int cmtId) {
		this.cmtId = cmtId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCmtDesc() {
		return cmtDesc;
	}
	public void setCmtDesc(String cmtDesc) {
		this.cmtDesc = cmtDesc;
	}
	public Timestamp getDateCmt() {
		return dateCmt;
	}
	public void setDateCmt(Timestamp dateCmt) {
		this.dateCmt = dateCmt;
	}
	public int getaMotorId() {
		return aMotorId;
	}
	public void setaMotorId(int aMotorId) {
		this.aMotorId = aMotorId;
	}
	public String getMotorName() {
		return motorName;
	}
	public void setMotorName(String motorName) {
		this.motorName = motorName;
	}
	public String getMotorColor() {
		return motorColor;
	}
	public void setMotorColor(String motorColor) {
		this.motorColor = motorColor;
	}
	
}
