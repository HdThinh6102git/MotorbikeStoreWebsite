package com.MotorbikeStore.service.impl;

import javax.inject.Inject;

import com.MotorbikeStore.dao.IUserDAO;
import com.MotorbikeStore.model.userModel;
import com.MotorbikeStore.service.ILoginService;

public class loginService  implements ILoginService {
	@Inject
	private IUserDAO userDAO;
	@Override
	public userModel login(String email, String pass) 
	{
		// TODO Auto-generated method stub
		return userDAO.login(email,pass);
//	if(umodel != null)
//		{
//			return null;
//		}
//		return umodel;
	}
}