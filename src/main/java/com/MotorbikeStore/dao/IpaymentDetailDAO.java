package com.MotorbikeStore.dao;

import java.util.List;

import com.MotorbikeStore.model.paymentDetailModel;

public interface IpaymentDetailDAO  extends GenericDAO<paymentDetailModel>{
	List<paymentDetailModel> findAll();
}
