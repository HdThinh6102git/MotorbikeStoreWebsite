package com.MotorbikeStore.dao.impl;

import com.MotorbikeStore.model.motorcyclesModel;

public class resetPasswordDAO extends AbstractDAO<motorcyclesModel> {
	

	public void updatePass(String  newPassword, String email) {
		String sql = "update user set user_pass = ? where email = ?";
		update(sql, newPassword,email);
	}

}
