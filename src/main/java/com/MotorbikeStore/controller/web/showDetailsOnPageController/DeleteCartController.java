package com.MotorbikeStore.controller.web.showDetailsOnPageController;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.service.ICartService;
import com.MotorbikeStore.service.CartStateService.Cart;
import com.MotorbikeStore.staticVariable.SystemStaticVariables;


@WebServlet("/DeleteCart")
public class DeleteCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
    private ICartService CartService;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = new Cart(SystemStaticVariables.State);
		cart.getState().removeItem(response,request,CartService );
		
//		String cartIdstr = request.getParameter("id"); 
//		String UserIdstr = request.getParameter("userId"); 
//		int userId = Integer.parseInt(UserIdstr);
//		int cartId = 0;
//		if(cartIdstr != null) {
//			cartId = Integer.parseInt(cartIdstr);
//		}
//		CartService.delete(cartId);
//		response.sendRedirect("cart?userId="+userId+"");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
