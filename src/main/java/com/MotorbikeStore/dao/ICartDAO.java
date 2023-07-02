package com.MotorbikeStore.dao;

import java.util.List;

import com.MotorbikeStore.model.CartModel;


public interface ICartDAO extends GenericDAO<CartModel>{
	int save(CartModel cart) ;
	List<CartModel> findAll();
	void delete(int cartId);
	List<CartModel> findByUserId(int userId);
}
