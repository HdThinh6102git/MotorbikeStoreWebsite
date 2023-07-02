package com.MotorbikeStore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.MotorbikeStore.dao.ICartDAO;
import com.MotorbikeStore.model.CartModel;
import com.MotorbikeStore.service.ICartService;

public class CartService implements ICartService {
	@Inject
	private ICartDAO CartDAO;
	@Override
	public int save(CartModel cart) {
		
		return CartDAO.save(cart);
	}

	@Override
	public List<CartModel> findAll() {
		
		return CartDAO.findAll();
	}

	@Override
	public void delete(int cartId) {
		CartDAO.delete(cartId);
		
	}

	@Override
	public List<CartModel> findByUserId(int userId) {
		
		return CartDAO.findByUserId(userId);
	}

}
