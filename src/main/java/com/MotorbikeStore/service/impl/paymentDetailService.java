package com.MotorbikeStore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.MotorbikeStore.dao.IpaymentDetailDAO;
import com.MotorbikeStore.model.paymentDetailModel;
import com.MotorbikeStore.service.IpaymentDetailService;

public class paymentDetailService implements IpaymentDetailService{
	@Inject
	private IpaymentDetailDAO paymentDetailDAO;
	@Override
	public List<paymentDetailModel> findAll() {
		
		return paymentDetailDAO.findAll();
	}

}
