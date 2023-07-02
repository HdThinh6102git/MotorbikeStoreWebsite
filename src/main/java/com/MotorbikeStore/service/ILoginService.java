package com.MotorbikeStore.service;

import com.MotorbikeStore.model.userModel;

public interface ILoginService 
{
	userModel login(String email,String pass);
	
}

