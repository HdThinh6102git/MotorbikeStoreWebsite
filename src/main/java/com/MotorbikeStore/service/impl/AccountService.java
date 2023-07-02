package com.MotorbikeStore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.MotorbikeStore.dao.IAccountDAO;
import com.MotorbikeStore.model.AccountModel;
import com.MotorbikeStore.service.IAccountService;

public class AccountService implements IAccountService {
	@Inject
	private IAccountDAO AccountDAO;

	@Override
	public List<AccountModel> findAll() {
		
		return AccountDAO.findAll();
	}

	@Override
	public void delete(int userId) {
		AccountDAO.delete(userId);
		
	}

	@Override
	public AccountModel findOneByUserId(int userId) {
		
		return AccountDAO.findOneByUserId(userId);
	}

	@Override
	public void update(AccountModel updateaccount) {
		AccountDAO.update(updateaccount);
		
	}
	
}
