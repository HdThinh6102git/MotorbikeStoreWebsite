package com.MotorbikeStore.service;

import java.util.List;

import com.MotorbikeStore.model.AccountModel;

public interface IAccountService {
	List<AccountModel> findAll();
	AccountModel findOneByUserId(int userId);
	void delete(int userId);
	void update(AccountModel updateaccount);
}
