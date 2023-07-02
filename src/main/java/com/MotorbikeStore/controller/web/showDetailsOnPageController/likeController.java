package com.MotorbikeStore.controller.web.showDetailsOnPageController;

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

import com.MotorbikeStore.model.CartModel;
import com.MotorbikeStore.model.PictureModel;
import com.MotorbikeStore.model.ProductDetailModel;
import com.MotorbikeStore.model.favoriteModel;
import com.MotorbikeStore.service.ICartService;
import com.MotorbikeStore.service.IPictureService;
import com.MotorbikeStore.service.IProductDetailService;

@WebServlet("/like")
public class likeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductDetailService productDetailService;
	@Inject
	private IPictureService PictureService;
	@Inject
	private ICartService cartService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		float prepaidMoney = 0f;
		// get aMotoId from cookie
		Cookie[] listCookie = request.getCookies();
		String valueCartCookie = "";
		if (listCookie != null) {
			for (Cookie o : listCookie) {
				if (o.getName().equals("cart")) {
					valueCartCookie += o.getValue();

				}
			}
		}

		favoriteModel favor = new favoriteModel();

		if (!valueCartCookie.isEmpty()) {
			String[] listAmotorId = new String[100];
			// Split the Cookie String Value to ListAMotorId
			if (valueCartCookie != null && valueCartCookie.length() != 0) {
				listAmotorId = valueCartCookie.split("/");
			}

			// get quantity of list to show on the header
			favor.setQuantity(listAmotorId.length);

			// find the product and picture by the listAMotorID to show on web page
			ProductDetailModel model = new ProductDetailModel();
			List<ProductDetailModel> list = new ArrayList<>();
			for (String o : listAmotorId) {

				list.add(productDetailService.findOneByAmotorId(Integer.parseInt(o)));
			}
			for (ProductDetailModel o : list) {
				prepaidMoney = o.getPrice() * 0.25f;
				o.setMoneyPrepaid(prepaidMoney);

			}
			PictureModel model2 = new PictureModel();
			model2.setPicPath(request.getContextPath() + "/uploads/images/product/");
			for (ProductDetailModel o : list) {
				model2 = PictureService.findOneByAmotorId(o.getaMotorId());
				if (model2 != null) {
					o.setPicName(model2.getPicName());
				}

			}

			model.setListResult(list);
			// set model to show product
			request.setAttribute("model", model);

		}
		// set model to show number favor on the header
		request.setAttribute("favorite", favor);
		
		
		
		// get and show number cart items in the header
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
		CartModel cartModel = new CartModel();
		cartModel.setQuantity(listCart.size());
		request.setAttribute("cart", cartModel);

		// show view
		RequestDispatcher rd = request.getRequestDispatcher("views/web/like.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
