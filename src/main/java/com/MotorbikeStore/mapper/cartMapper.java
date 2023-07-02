package com.MotorbikeStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MotorbikeStore.model.CartModel;

public class cartMapper implements RowMapper<CartModel> {

	@Override
	public CartModel mapRow(ResultSet resultSet) {
		try {
			
			CartModel cart = new CartModel();
			cart.setaMotorId(resultSet.getInt("a_motor_id"));
			cart.setCartId(resultSet.getInt("cart_id"));
			cart.setUserId(resultSet.getInt("user_id"));
			
			
			
			
			return cart;
		} catch (SQLException e) {
			return null;
		}
	}

}
