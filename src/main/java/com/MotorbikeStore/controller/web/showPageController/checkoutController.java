package com.MotorbikeStore.controller.web.showPageController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.MotorbikeStore.model.ProductDetailModel;
import com.MotorbikeStore.model.favoriteModel;
import com.MotorbikeStore.service.ICartService;
import com.MotorbikeStore.service.IProductDetailService;
import com.MotorbikeStore.staticVariable.SystemStaticVariables;

@WebServlet("/checkout")
public class checkoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductDetailService productDetailService;
	@Inject
	private ICartService cartService;
	@Inject
	private IDetailsOnNavBar detailsOnNavBar;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SystemStaticVariables.State = "CheckoutState";
		System.out.println(SystemStaticVariables.State);
		// show number in favor
		Cookie[] listCookie = request.getCookies();
		favoriteModel favor = new favoriteModel();
		favor = detailsOnNavBar.showFavoriteProductNum(favor, listCookie);
		request.setAttribute("favorite", favor);

		/////

		//show information of product in cart 
		HttpSession session = request.getSession();
		String userIdstr = null;
		if(session.getAttribute("userId") != null) {
			userIdstr = session.getAttribute("userId").toString();
		}
		int userId = 0;

		if (userIdstr != null) {
			userId = Integer.parseInt(userIdstr);

		}
		List<CartModel> listCart = cartService.findByUserId(userId);

		List<Integer> listAmotorId = new ArrayList<>();
		ProductDetailModel model = new ProductDetailModel();
		List<ProductDetailModel> listProduct = new ArrayList<>();
		CartModel cart = new CartModel();
		cart.setListResult(listCart);
		for (CartModel o : listCart) {

			listAmotorId.add(o.getaMotorId());
		}
		float totalPrice = 0;
		float deposit = 0f;

		for (int o : listAmotorId) {

			listProduct.add(productDetailService.findOneByAmotorId(o));
		}

		for (ProductDetailModel o : listProduct) {
			for (CartModel o1 : listCart) {

				o.setCartId(o1.getCartId());
				listCart.remove(o1);
				break;
			}
			deposit = o.getPrice() * 0.25f;
			o.setMoneyPrepaid(deposit);
			totalPrice += deposit;
		}

		cart.setQuantity(listAmotorId.size());
		model.setListResult(listProduct);

		request.setAttribute("model", model);

		cart.setTotalPrice(totalPrice);

		request.setAttribute("cart", cart);
		RequestDispatcher rd = request.getRequestDispatcher("views/web/checkout.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
