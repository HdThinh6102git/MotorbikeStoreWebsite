package com.MotorbikeStore.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import com.MotorbikeStore.dao.IpaymentDAO;
import com.MotorbikeStore.mapper.paymentMapper;
import com.MotorbikeStore.model.paymentModel;

public class paymentDAO extends AbstractDAO<paymentModel> implements IpaymentDAO {

	@Override
	public int save(paymentModel payment) {
		
		String sql = "insert into payment (a_motor_id, date_buy, date_prepaid, money_prepaid, price, payment_menthod, cus_id) value(?,?,?,?,?,'prepaid',?);";
		payment.setDateBuy(new Timestamp(System.currentTimeMillis()));
		payment.setDatePrepaid(new Timestamp(System.currentTimeMillis()));
		float moneyPrepaid = payment.getPrice()*0.25f;
		return insert(sql, payment.getaMotorId(), payment.getDateBuy(), payment.getDatePrepaid(),moneyPrepaid,  payment.getPrice(), payment.getCusId());
	}

	@Override
	public void delete(int paymentId) {
		String sql = "delete from payment where payment_id = ?";
		update(sql, paymentId);
	}

	@Override
	public paymentModel findOneById(int paymentId) {
		String sql = "select * from payment where payment_id = ?";
		List<paymentModel> list = query(sql, new paymentMapper(), paymentId);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void update(paymentModel updatePayment) {
		
		String sql = "update payment set money_prepaid = ? , date_prepaid = ? where payment_id = ? ;";
		updatePayment.setDatePrepaid(new Timestamp(System.currentTimeMillis()));
		update(sql, updatePayment.getMoneyPrepaid(), updatePayment.getDatePrepaid(), updatePayment.getPaymentId());
	}

	@Override
	public int UserIsCustomer(int userId) {
		String sql = "select * from payment where user_id = ?;";
		List<paymentModel> list = query(sql, new paymentMapper(), userId);
		return list.size();
	}

	

	

}
