package com.MotorbikeStore.model;

public class motorcyclesModel extends AbstractModel<motorcyclesModel>{
	private int motorsId; 
	private String motors_Name;
	private String version; 
	private String motorType; 
	private String branch;
	private String style; 
	private int quantity;
	private String checkSale;
	private String motors_decs;
	
	
	
	
	public int getMotorsId() {
		return motorsId;
	}
	public void setMotorsId(int motorsId) {
		this.motorsId = motorsId;
	}
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getMotors_decs() {
		return motors_decs;
	}
	public void setMotors_decs(String motors_decs) {
		this.motors_decs = motors_decs;
	}
	
	public String getCheckSale() {
		return checkSale;
	}
	public void setCheckSale(String checkSale) {
		this.checkSale = checkSale;
	}
}
