package com.MotorbikeStore.controller.web.showPageController;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MotorbikeStore.controller.web.showDetailsOnPageController.showDetailsOnNavBar.IDetailsOnNavBar;
import com.MotorbikeStore.model.CartModel;
import com.MotorbikeStore.model.favoriteModel;

@WebServlet("/meetingPlan")
public class meetingPlanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IDetailsOnNavBar detailsOnNavBar;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// show number favor in the header
		favoriteModel favor = new favoriteModel();
		Cookie[] listCookie = request.getCookies();
		favor = detailsOnNavBar.showFavoriteProductNum(favor, listCookie);
		request.setAttribute("favorite", favor);

		// show number cart items in the header
		HttpSession session = request.getSession();
		CartModel cartModel = new CartModel();
		cartModel = detailsOnNavBar.showCartNum(session, cartModel);
		request.setAttribute("cart", cartModel);

		RequestDispatcher rd = request.getRequestDispatcher("views/web/meetingPlan.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
