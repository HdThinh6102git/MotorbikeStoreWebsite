package com.MotorbikeStore.controller.web.showDetailsOnPageController.showDetailsOnNavBar;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import com.MotorbikeStore.model.CartModel;
import com.MotorbikeStore.model.favoriteModel;
import com.MotorbikeStore.service.ICartService;
import com.MotorbikeStore.service.impl.CartService;

public class DetailsOnNavBar  implements IDetailsOnNavBar {
	
	@Inject
	private ICartService cartService;
	
	@Override
	public favoriteModel showFavoriteProductNum(favoriteModel favor, Cookie[] listCookie) {
		
		String valueCartCookie = "";
		if (listCookie != null) {
			for (Cookie o : listCookie) {
				if (o.getName().equals("cart")) {
					valueCartCookie += o.getValue();

				}
			}
		}
		
		
		if (!valueCartCookie.isEmpty()) {
			String[] listAmotorId = new String[100];
			if (valueCartCookie != null && valueCartCookie.length() != 0) {
				listAmotorId = valueCartCookie.split("/");
			}
			favor.setQuantity(listAmotorId.length);
			
		}
		return favor;
	}

	@Override
	public CartModel showCartNum(HttpSession session, CartModel cartModel) {
		
		String userIdstr = null;
		if(session.getAttribute("userId") != null) {
			userIdstr = session.getAttribute("userId").toString();
		}
		
		int userId = 0;

		if (userIdstr != null) {
			userId = Integer.parseInt(userIdstr);

		}
		List<CartModel> listCart = cartService.findByUserId(userId);
		
		cartModel.setQuantity(listCart.size());
		return cartModel;
	}

}
