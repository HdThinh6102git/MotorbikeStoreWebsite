package com.MotorbikeStore.model;

public class specificationModel extends AbstractModel<specificationModel>{
	private int motorsId; 
	private String size; 
	private float massKg; 
	private float saddleHeightCm; 
	private int rpm; 
	private float engineTorque; 
	private String horsePower;
	public int getMotorsId() {
		return motorsId;
	}
	public void setMotorsId(int motorsId) {
		this.motorsId = motorsId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public float getMassKg() {
		return massKg;
	}
	public void setMassKg(float massKg) {
		this.massKg = massKg;
	}
	public float getSaddleHeightCm() {
		return saddleHeightCm;
	}
	public void setSaddleHeightCm(float saddleHeightCm) {
		this.saddleHeightCm = saddleHeightCm;
	}
	public int getRpm() {
		return rpm;
	}
	public void setRpm(int rpm) {
		this.rpm = rpm;
	}
	public float getEngineTorque() {
		return engineTorque;
	}
	public void setEngineTorque(float engineTorque) {
		this.engineTorque = engineTorque;
	}
	public String getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(String horsePower) {
		this.horsePower = horsePower;
	}
	
	
}
