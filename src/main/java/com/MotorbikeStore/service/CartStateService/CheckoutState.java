package com.MotorbikeStore.service.CartStateService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.service.ICartService;

public class CheckoutState extends State{

	CheckoutState(Cart cart) {
		super(cart);
		
	}

	
	

	@Override
	public void removeItem(HttpServletResponse response,HttpServletRequest request, ICartService cartService) throws IOException {
		// TODO Do nothing, the cart is in the checkout state 
		System.out.println("Can not remove item on checkout State");
		
		
		
		String UserIdstr = request.getParameter("userId"); 
		int userId = Integer.parseInt(UserIdstr);
		
		response.sendRedirect("cart?userId="+userId+"");
	}


	@Override
	public void addItem( HttpServletResponse response,HttpServletRequest request, ICartService cartService) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Can not add item on checkout State");
		String aMotorIdstr = request.getParameter("aMotorId");
		int idpage = Integer.parseInt(request.getParameter("idpage"));
		int aMotorId = 0;
		if (aMotorIdstr != null) {
			aMotorId = Integer.parseInt(aMotorIdstr);
		}
		if (idpage == 0) {
			response.sendRedirect("web-main-page");
		} else if (idpage == 1) {
			response.sendRedirect("shop");
		} else if (idpage == 2) {
			response.sendRedirect("notaddshopDetail?id=" + aMotorId + "");
		}
	}

}
