package com.MotorbikeStore.service;

import java.util.List;

import com.MotorbikeStore.model.CartModel;

public interface ICartService {
	int save(CartModel cart) ;
	List<CartModel> findAll();
	void delete(int cartId);
	List<CartModel> findByUserId(int userId);
}
