package com.MotorbikeStore.dao;

import com.MotorbikeStore.model.paymentModel;

public interface IpaymentDAO extends GenericDAO<paymentModel> {
	int save(paymentModel payment);
	void delete(int paymentId);
	paymentModel findOneById(int paymentId);
	void update(paymentModel updatePayment);
	int UserIsCustomer(int userId);
}
