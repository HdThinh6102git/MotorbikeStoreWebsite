package com.MotorbikeStore.dao.impl;

import java.util.List;

import com.MotorbikeStore.mapper.UserMapper;
import com.MotorbikeStore.model.userModel;

public class forgotPassDAO extends AbstractDAO<userModel>
{
	public Boolean checkExistEmail(String email) {
		String sql = "select * from USER as u where u.email = ?";

		List<userModel> users = query(sql, new UserMapper(),email);
		
		return users.isEmpty() ? false : true; //false tra ve:ko ton tai vs ngc lai
		
	}
}
