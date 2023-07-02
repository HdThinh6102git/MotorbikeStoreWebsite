package com.MotorbikeStore.dao.impl;

import java.util.List;

import com.MotorbikeStore.dao.IpaymentDetailDAO;
import com.MotorbikeStore.mapper.paymentDetailMapper;
import com.MotorbikeStore.model.paymentDetailModel;

public class paymentDetailDAO extends AbstractDAO<paymentDetailModel> implements IpaymentDetailDAO{

	@Override
	public List<paymentDetailModel> findAll() {
		String sql = "select p.payment_id,status, cus_name,   motors_name, color,date_buy, date_prepaid, money_prepaid, p.price, payment_menthod from motorcycles as m,payment as p , customer as c, a_motorcycle as a where p.cus_id = c.cus_id and p.a_motor_id = a.a_motor_id and m.motors_id and m.motors_id = a.motors_id ;";
		return query(sql, new paymentDetailMapper());
	}

}
