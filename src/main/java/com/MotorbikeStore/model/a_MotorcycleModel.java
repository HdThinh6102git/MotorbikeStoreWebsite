package com.MotorbikeStore.model;

import java.sql.Timestamp;

public class a_MotorcycleModel extends AbstractModel<a_MotorcycleModel>{
	private int aMotorId;
	private int motorsId;
	private String color; 
	private Float price;
	private Timestamp dateInsert;
	private Timestamp dateUpdate;
	private String checkSold;
	private String aMotorDesc;
	public String getCheckSold() {
		return checkSold;
	}
	public void setCheckSold(String checkSold) {
		this.checkSold = checkSold;
	}
	public int getaMotorId() {
		return aMotorId;
	}
	public void setaMotorId(int aMotorId) {
		this.aMotorId = aMotorId;
	}
	public int getMotorsId() {
		return motorsId;
	}
	public void setMotorsId(int motorsId) {
		this.motorsId = motorsId;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Timestamp getDateInsert() {
		return dateInsert;
	}
	public void setDateInsert(Timestamp dateInsert) {
		this.dateInsert = dateInsert;
	}
	public Timestamp getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(Timestamp dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	public String getaMotorDesc() {
		return aMotorDesc;
	}
	public void setaMotorDesc(String aMotorDesc) {
		this.aMotorDesc = aMotorDesc;
	}
	
	
}
