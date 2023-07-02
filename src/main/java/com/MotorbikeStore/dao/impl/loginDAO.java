package com.MotorbikeStore.dao.impl;
import java.util.List;

import com.MotorbikeStore.dao.IUserDAO;
import com.MotorbikeStore.mapper.UserMapper;
import com.MotorbikeStore.model.userModel;

public class loginDAO extends AbstractDAO<userModel> implements  IUserDAO
{
	public userModel login(String email,String pass) {
		String sql = "select * from user as u inner join role as r on r.role_id = u.role_id"
				+ " where u.email = ? and u.user_pass = ? and u.check_delete = 'still'";

		List<userModel> users = query(sql, new UserMapper(),email,pass);
		
		return users.isEmpty() ? null: users.get(0); //tra ve thang dau tien trong db
		
	}

}
