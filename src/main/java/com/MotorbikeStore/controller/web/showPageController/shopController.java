package com.MotorbikeStore.controller.web.showPageController;

import java.io.IOException;
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
import com.MotorbikeStore.model.PictureModel;
import com.MotorbikeStore.model.ProductDetailModel;
import com.MotorbikeStore.model.favoriteModel;
import com.MotorbikeStore.service.IPictureService;
import com.MotorbikeStore.service.IProductDetailService;

@WebServlet("/shop")
public class shopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductDetailService productDetailService;
	@Inject
	private IPictureService PictureService;
	
	@Inject
	private IDetailsOnNavBar detailsOnNavBar;
	
	private ProductDetailModel showAllProducts(ProductDetailModel model) {
		List<ProductDetailModel> list = productDetailService.findAll();
		PictureModel model2 = new PictureModel();
		
		for (ProductDetailModel o : list) {
			model2 = PictureService.findOneByAmotorId(o.getaMotorId());
			if (model2 != null) {
				o.setPicName(model2.getPicName());
			}

		}
		model.setListResult(list);
		return model;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// show all product
		ProductDetailModel model = new ProductDetailModel();
		model = showAllProducts(model);
		request.setAttribute("model", model);

		
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

		// show view shop page
		RequestDispatcher rd = request.getRequestDispatcher("views/web/shop.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
