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

@WebServlet("/addCart")
public class ShoppingCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ICartService cartService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Cart cart = new Cart(SystemStaticVariables.State);
		cart.getState().addItem(response, request,  cartService);
//		if (session.getAttribute("name") != null && session.getAttribute("role") == "user") {
//			String aMotorIdStr = request.getParameter("aMotorId");
//			String userIdStr = request.getParameter("userId");
//			int aMotorId = 0;
//			int userId = 0;
//			if (aMotorIdStr != null) {
//				aMotorId = Integer.parseInt(aMotorIdStr);
//			}
//			if (userIdStr != null) {
//				userId = Integer.parseInt(userIdStr);
//			}
//
//			CartModel cartModel = new CartModel();
//			cartModel.setaMotorId(aMotorId);
//			cartModel.setUserId(userId);
//			cartService.save(cartModel);
//
//			if (idpage == 0) {
//				response.sendRedirect("web-main-page");
//			} else if (idpage == 1) {
//				response.sendRedirect("shop");
//			} else if (idpage == 2) {
//				response.sendRedirect("notaddshopDetail?id=" + aMotorId + "");
//			}
//
//		} else {
//			if (aMotorIdstr != null) {
//				response.sendRedirect("login");
//			}
//
//		}
	}

}
