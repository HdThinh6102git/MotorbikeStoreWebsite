package com.MotorbikeStore.service;

import com.MotorbikeStore.model.customerModel;

public interface IcustomerService {
	int save(customerModel customer);
	void delete(int cusId);
}
