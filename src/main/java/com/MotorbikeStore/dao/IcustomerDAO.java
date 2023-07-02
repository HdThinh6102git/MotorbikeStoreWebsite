package com.MotorbikeStore.dao;

import com.MotorbikeStore.model.customerModel;

public interface IcustomerDAO extends GenericDAO<customerModel>{
	int save(customerModel customer);
	void delete(int cusId);
	customerModel findOne(int cusId);
}
