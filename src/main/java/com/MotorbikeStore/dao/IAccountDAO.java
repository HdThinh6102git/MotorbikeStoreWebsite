package com.MotorbikeStore.dao;

import java.util.List;

import com.MotorbikeStore.model.AccountModel;

public interface IAccountDAO extends GenericDAO<AccountModel>{
	List<AccountModel> findAll();
	AccountModel findOneByUserId(int userId);
	void delete(int userId);
	void update(AccountModel updateaccount);
	
}
