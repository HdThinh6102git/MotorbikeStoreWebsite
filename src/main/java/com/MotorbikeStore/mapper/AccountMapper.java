package com.MotorbikeStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MotorbikeStore.model.AccountModel;

public class AccountMapper implements RowMapper<AccountModel>{

	@Override
	public AccountModel mapRow(ResultSet resultSet) {
		try {
			AccountModel account = new AccountModel();
			account.setUserId(resultSet.getInt("user_id"));
			account.setUserName(resultSet.getString("user_name"));
			account.setUserPass(resultSet.getString("user_pass"));
			account.setRoleName(resultSet.getString("role_name"));
			account.setEmail(resultSet.getString("email"));
			account.setPhoneNum(resultSet.getInt("num_phone"));
			account.setIdCard(resultSet.getInt("cccd"));
			
			return account;
		} catch (SQLException e) {
			return null;
		}
	}

}
