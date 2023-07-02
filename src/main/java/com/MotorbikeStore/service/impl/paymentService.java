package com.MotorbikeStore.service.impl;

import javax.inject.Inject;

import com.MotorbikeStore.dao.IpaymentDAO;
import com.MotorbikeStore.model.paymentModel;
import com.MotorbikeStore.service.IpaymentService;

public class paymentService implements IpaymentService {
	@Inject
	private IpaymentDAO paymentDAO;
	@Override
	public int save(paymentModel payment) {
		
		return paymentDAO.save(payment);
	}

	@Override
	public void delete(int paymentId) {
		paymentDAO.delete(paymentId);
		
	}

	@Override
	public paymentModel findOneById(int paymentId) {
		// TODO Auto-generated method stub
		return paymentDAO.findOneById(paymentId);
	}

	@Override
	public void update(paymentModel updatePayment) {
		paymentDAO.update(updatePayment);
		
	}

	@Override
	public boolean UserIsCustomer(int userId) {
		if(paymentDAO.UserIsCustomer(userId) > 0) {
			return true;
		}
		return false;
	}

	

}
