package com.MotorbikeStore.service.CartStateService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.service.ICartService;

public abstract class State {
	Cart cart;
	State(Cart cart){
		this.cart = cart;
	}
	
	
	public abstract void addItem(HttpServletResponse response,HttpServletRequest request,ICartService cartService ) throws IOException;
	public abstract void removeItem(HttpServletResponse response,HttpServletRequest request, ICartService cartService) throws IOException;
}
