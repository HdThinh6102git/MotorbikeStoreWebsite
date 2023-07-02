package com.MotorbikeStore.dao.impl;

import com.MotorbikeStore.dao.IcustomerDAO;
import com.MotorbikeStore.model.customerModel;

public class customerDAO extends AbstractDAO<customerModel> implements IcustomerDAO {

	@Override
	public int save(customerModel customer) {
		String sql = "insert into customer (cus_name, id_card, email, phoneNum, address, country) value(?,?,?,?,?,?);";
		return insert(sql, customer.getCusName(), customer.getIdCard(), customer.getEmail(), customer.getPhoneNum(), customer.getAddress(), customer.getCountry());
	}

	@Override
	public void delete(int cusId) {
		String sql = "delete from customer where cus_id = ?";
		update(sql, cusId);
	}

	@Override
	public customerModel findOne(int cusId) {
		String sql = "select * from customer where cus_id = ?";
		return null;
	}

}
