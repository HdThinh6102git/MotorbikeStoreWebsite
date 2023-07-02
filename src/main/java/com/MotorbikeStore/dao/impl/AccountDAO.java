package com.MotorbikeStore.dao.impl;

import java.util.List;

import com.MotorbikeStore.dao.IAccountDAO;
import com.MotorbikeStore.mapper.AccountMapper;
import com.MotorbikeStore.model.AccountModel;

public class AccountDAO extends AbstractDAO<AccountModel> implements IAccountDAO {

	@Override
	public List<AccountModel> findAll() {
		String sql ="select user_id, user_name, user_pass, role_name, email, num_phone, cccd from user as u , role as r where u.role_id = r.role_id;";
		return query(sql, new AccountMapper());
	}

	@Override
	public void delete(int userId) {
		String sql = "delete from user where user_id = ?;";
		update(sql, userId);
		
	}

	@Override
	public AccountModel findOneByUserId(int userId) {
		String sql ="select user_id, user_name, user_pass, role_name, email, num_phone, cccd from user as u , role as r where u.role_id = r.role_id and  user_id = ?;";
		List<AccountModel> list = query(sql, new AccountMapper(), userId);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void update(AccountModel updateaccount) {
		String sql = "update user set user_name = ?, user_pass = ?, email = ?, num_phone =?, cccd = ? where user_id = ?";
		update(sql, updateaccount.getUserName(), updateaccount.getUserPass(), updateaccount.getEmail(), updateaccount.getPhoneNum(), updateaccount.getIdCard(), updateaccount.getUserId());
		
	}

	
}
