package com.MotorbikeStore.service.CartStateService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MotorbikeStore.model.CartModel;
import com.MotorbikeStore.service.ICartService;

public class ActiveState extends State{
	
	ActiveState(Cart cart) {
		super(cart);
		
	}

	
	

	@Override
	public void removeItem(HttpServletResponse response,HttpServletRequest request, ICartService cartService) throws IOException {
		// TODO Remove item from the list of items 
		System.out.println("remove item on active State");
		String cartIdstr = request.getParameter("id"); 
		String UserIdstr = request.getParameter("userId"); 
		int userId = Integer.parseInt(UserIdstr);
		int cartId = 0;
		if(cartIdstr != null) {
			cartId = Integer.parseInt(cartIdstr);
		}
		cartService.delete(cartId);
		response.sendRedirect("cart?userId="+userId+"");
	}


	@Override
	public void addItem( HttpServletResponse response,HttpServletRequest request,  ICartService cartService) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Add item on active State");
		HttpSession session = request.getSession();
		String aMotorIdstr = request.getParameter("aMotorId");
		int idpage = Integer.parseInt(request.getParameter("idpage"));
		if (session.getAttribute("name") != null && session.getAttribute("role") == "user") {
			String aMotorIdStr = request.getParameter("aMotorId");
			String userIdStr = request.getParameter("userId");
			int aMotorId = 0;
			int userId = 0;
			if (aMotorIdStr != null) {
				aMotorId = Integer.parseInt(aMotorIdStr);
			}
			if (userIdStr != null) {
				userId = Integer.parseInt(userIdStr);
			}

			CartModel cartModel = new CartModel();
			cartModel.setaMotorId(aMotorId);
			cartModel.setUserId(userId);
			cartService.save(cartModel);

			if (idpage == 0) {
				response.sendRedirect("web-main-page");
			} else if (idpage == 1) {
				response.sendRedirect("shop");
			} else if (idpage == 2) {
				response.sendRedirect("notaddshopDetail?id=" + aMotorId + "");
			}

		} else {
			if (aMotorIdstr != null) {
				response.sendRedirect("login");
			}

		}
	}




	

}
