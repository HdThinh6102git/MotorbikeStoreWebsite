package com.MotorbikeStore.dao;

import com.MotorbikeStore.model.userModel;

public interface IUserDAO {
	userModel login(String email,String pass);
	
}
