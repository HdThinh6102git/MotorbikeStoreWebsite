package com.MotorbikeStore.controller.web.showDetailsOnPageController.showDetailsOnNavBar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import com.MotorbikeStore.model.CartModel;
import com.MotorbikeStore.model.favoriteModel;

public interface IDetailsOnNavBar {
	public favoriteModel showFavoriteProductNum(favoriteModel favor,Cookie[] listCookie );
	public CartModel showCartNum(HttpSession session, CartModel cartModel);
}
