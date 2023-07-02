package com.MotorbikeStore.service.impl;

import com.MotorbikeStore.dao.impl.regisDAO;
import com.MotorbikeStore.model.userModel;
import com.MotorbikeStore.service.IRegisService;

public class regisService implements IRegisService
{

	private regisDAO checkMailExist = new regisDAO();

	@Override
	public int regisUser(String pass, String uname, String cccd, String phone, String email) {
		if (checkMailExist.checkExistEmail(email,cccd)== false)	
		{
			// TODO Auto-generated method stub
		    userModel umodel = new userModel();
		    umodel.setUserPass(pass);
		    umodel.setUserName(uname);
		    umodel.setNumPhone(phone);
		    umodel.setEmail(email);
		    umodel.setCCCD(cccd);
			regisDAO userDAO = new regisDAO(); 
			if (userDAO.create(umodel) > 0)
			{
				return 1;
			} 
			return 0;
		}
		else
		{
			return -1;
		}
	
	}
}
