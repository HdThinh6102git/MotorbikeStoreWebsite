package com.MotorbikeStore.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.MotorbikeStore.dao.impl.resetPasswordDAO;

public class resetPasswordService {
	resetPasswordDAO rPassDAO = new resetPasswordDAO();
	public int resetPassword(String  newPassword, String email) {
		try {
			rPassDAO.updatePass(newPassword,email);
			return 1;
			}
		catch (Exception e) {
				return 0;
			}
	}
}
