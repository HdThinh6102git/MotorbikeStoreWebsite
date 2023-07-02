package com.MotorbikeStore.dao.impl;

import java.util.List;

import com.MotorbikeStore.mapper.UserMapper;
import com.MotorbikeStore.model.userModel;

public class regisDAO extends AbstractDAO<userModel>
{
	public int create(userModel newUser) {
		String sql ="insert into USER(user_pass,user_name,cccd,num_phone,email) values(?,?,?,?,?)";

		return insert(sql,newUser.getUserPass(), newUser.getUserName(), newUser.getCCCD(), newUser.getNumPhone(), newUser.getEmail());
	}
	public Boolean checkExistEmail(String email,String cccd) {
		String sql = "select * from USER as u where u.email = ? or u.cccd=?";

		List<userModel> users = query(sql, new UserMapper(),email,cccd);
		
		return users.isEmpty() ? false : true; //false tra ve:ko ton tai vs ngc lai
		
	}
}
