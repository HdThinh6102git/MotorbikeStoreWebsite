package com.MotorbikeStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MotorbikeStore.model.paymentDetailModel;

public class paymentDetailMapper implements RowMapper<paymentDetailModel> {

	@Override
	public paymentDetailModel mapRow(ResultSet resultSet) {
		
		try {
			paymentDetailModel paymentDetail = new paymentDetailModel();
			paymentDetail.setStatus(resultSet.getString("status"));
			paymentDetail.setPaymentId(resultSet.getInt("payment_id"));
			paymentDetail.setCusName(resultSet.getString("cus_name"));
			paymentDetail.setMotorsName(resultSet.getString("motors_name"));
			paymentDetail.setColor(resultSet.getString("color"));
			paymentDetail.setDateBuy(resultSet.getTimestamp("date_buy"));
			paymentDetail.setDatePrepaid(resultSet.getTimestamp("date_prepaid"));
			paymentDetail.setMoneyPrepaid(resultSet.getFloat("money_prepaid"));
			paymentDetail.setPrice(resultSet.getFloat("price"));
			paymentDetail.setPaymentMethod(resultSet.getString("payment_menthod"));
			
			
			
			
			
			return paymentDetail;
		} catch (SQLException e) {
			return null;
		}
	}

}
