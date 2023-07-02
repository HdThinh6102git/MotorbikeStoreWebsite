package com.MotorbikeStore.service;

import com.MotorbikeStore.model.paymentModel;

public interface IpaymentService {
	int save(paymentModel payment);
	void delete(int paymentId);
	paymentModel findOneById(int paymentId);
	void update(paymentModel updatePayment);
	boolean UserIsCustomer(int userId);
}
