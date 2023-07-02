package com.MotorbikeStore.service.impl;

import javax.inject.Inject;

import com.MotorbikeStore.dao.IcustomerDAO;
import com.MotorbikeStore.model.customerModel;
import com.MotorbikeStore.service.IcustomerService;

public class customerService implements IcustomerService {
	@Inject
	private IcustomerDAO customerDAO;
	@Override
	public int save(customerModel customer) {
		
		return customerDAO.save(customer);
	}

	@Override
	public void delete(int cusId) {
		customerDAO.delete(cusId);
		
	}

}
