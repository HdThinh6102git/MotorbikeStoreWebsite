package com.MotorbikeStore.dao.impl;

import java.util.List;

import com.MotorbikeStore.dao.ICartDAO;
import com.MotorbikeStore.mapper.cartMapper;
import com.MotorbikeStore.model.CartModel;

public class CartDAO extends AbstractDAO<CartModel> implements ICartDAO {

	@Override
	public int save(CartModel cart) {
		String sql = "insert into cart (a_motor_id, user_id) value(?, ?);";
		return insert(sql, cart.getaMotorId(), cart.getUserId());
	}

	@Override
	public List<CartModel> findAll() {
		String sql = "select * from cart";
		return query(sql, new cartMapper());
	}

	@Override
	public void delete(int cartId) {
		String sql = "delete from cart where cart_id = ?";
		update(sql, cartId);
		
	}

	@Override
	public List<CartModel> findByUserId(int userId) {
		String sql = "select * from cart where user_id = ?";
		return query(sql, new cartMapper(), userId);
	}

}
