package com.MotorbikeStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MotorbikeStore.model.paymentModel;

public class paymentMapper implements RowMapper<paymentModel>{

	@Override
	public paymentModel mapRow(ResultSet resultSet) {
		
		try {
			paymentModel payment = new paymentModel();
			payment.setaMotorId(resultSet.getInt("a_motor_id"));
			payment.setPaymentId(resultSet.getInt("payment_id"));
			payment.setDateBuy(resultSet.getTimestamp("date_buy"));
			payment.setDatePrepaid(resultSet.getTimestamp("date_prepaid"));
			payment.setMoneyPrepaid(resultSet.getFloat("money_prepaid"));
			payment.setPrice(resultSet.getFloat("price"));
			payment.setPaymentMethod(resultSet.getString("payment_menthod"));
			payment.setStatus(resultSet.getString("status"));
			payment.setCusId(resultSet.getInt("cus_id"));
			return payment;
		} catch (SQLException e) {
			return null;
		}
	}

}
