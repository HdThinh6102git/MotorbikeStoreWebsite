package com.MotorbikeStore.service.CartStateService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.service.ICartService;

public class InActiveState extends State{

	InActiveState(Cart cart) {
		super(cart);
		
	}

	

	@Override
	public void addItem( HttpServletResponse response,HttpServletRequest request, ICartService cartService) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Can not Add item on InActive State, login");
		
	}

	@Override
	public void removeItem(HttpServletResponse response,HttpServletRequest request, ICartService cartService) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Can not remove item on InActive State, login");
	}




	

}
