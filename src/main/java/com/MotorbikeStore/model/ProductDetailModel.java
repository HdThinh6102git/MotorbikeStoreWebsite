package com.MotorbikeStore.model;

import java.sql.Timestamp;

public class ProductDetailModel extends AbstractModel<ProductDetailModel>{
	private int aMotorId;
	private int cartId;
	private int motorsId;
	private String motors_Name;
	private String version; 
	private String motorType; 
	private String branch;
	private String style; 
	private Float CC;
	private String color; 
	private float price; 
	private float moneyPrepaid;
	private Timestamp date_insert;
	private String motorsDecs;
	private String picName;
	private String aMotorDesc;
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getaMotorId() {
		return aMotorId;
	}
	public void setaMotorId(int aMotorId) {
		this.aMotorId = aMotorId;
	}
	public Timestamp getDate_insert() {
		return date_insert;
	}
	public void setDate_insert(Timestamp date_insert) {
		this.date_insert = date_insert;
	}
	private String checkSold;
	
	public String getMotors_Name() {
		return motors_Name;
	}
	public void setMotors_Name(String motors_Name) {
		this.motors_Name = motors_Name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getMotorType() {
		return motorType;
	}
	public void setMotorType(String motorType) {
		this.motorType = motorType;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCheckSold() {
		return checkSold;
	}
	public void setCheckSold(String checkSold) {
		this.checkSold = checkSold;
	}
	public int getMotorsId() {
		return motorsId;
	}
	public void setMotorsId(int motorsId) {
		this.motorsId = motorsId;
	}
	public String getMotorsDecs() {
		return motorsDecs;
	}
	public void setMotorsDecs(String motorsDecs) {
		this.motorsDecs = motorsDecs;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public Float getCC() {
		return CC;
	}
	public void setCC(Float cC) {
		CC = cC;
	}
	public float getMoneyPrepaid() {
		return moneyPrepaid;
	}
	public void setMoneyPrepaid(float moneyPrepaid) {
		this.moneyPrepaid = moneyPrepaid;
	}
	public String getaMotorDesc() {
		return aMotorDesc;
	}
	public void setaMotorDesc(String aMotorDesc) {
		this.aMotorDesc = aMotorDesc;
	}
	
	
	
}
