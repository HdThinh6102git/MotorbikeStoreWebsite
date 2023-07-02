package com.MotorbikeStore.controller.web.showPageController;

import java.io.IOException;
import java.util.Iterator;
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
import com.MotorbikeStore.staticVariable.SystemStaticVariables;

import com.MotorbikeStore.utils.IterableList;

@WebServlet(urlPatterns = { "/web-main-page" })
public class HomeController extends HttpServlet {
	public static final String POLICY = "default-src 'self'";
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductDetailService productDetailService;
	@Inject
	private IPictureService PictureService;
	
	
	@Inject
	private IDetailsOnNavBar detailsOnNavBar;
	
	
	private ProductDetailModel showRecentProduct(ProductDetailModel productModel) {
		IterableList<ProductDetailModel> list = new IterableList<ProductDetailModel>(productDetailService.findNumberOfMotor(8));
		PictureModel model2 = new PictureModel();
		
		
		Iterator<ProductDetailModel> it = list.iterator();
		while(it.hasNext()) {
			ProductDetailModel temp = it.next();
			model2 = PictureService.findOneByAmotorId(temp.getaMotorId());
			if (model2 != null) {
				temp.setPicName(model2.getPicName());
			}
		}
		productModel.setListResult(list);
		return productModel;
		
		
		/*
		List<ProductDetailModel> list = productDetailService.findNumberOfMotor(8);
		PictureModel model2 = new PictureModel();
		
		
		for (ProductDetailModel o : list) {
			
			model2 = PictureService.findOneByAmotorId(o.getaMotorId());
			if (model2 != null) {
				o.setPicName(model2.getPicName());
			}

		}
		productModel.setListResult(list);
		return productModel;
		*/
	}
	
	private ProductDetailModel showFeatureProduct(ProductDetailModel modelFeature) {
		IterableList<ProductDetailModel> listFeature = new IterableList<ProductDetailModel>(productDetailService.findNumberOfMotorFeature(8, "xe đẹp"));
		PictureModel modelpicfeature = new PictureModel();
		
		Iterator<ProductDetailModel> it = listFeature.iterator();
		while(it.hasNext()) {
			ProductDetailModel temp = it.next();
			modelpicfeature = PictureService.findOneByAmotorId(temp.getaMotorId());
			if (modelpicfeature != null) {
				temp.setPicName(modelpicfeature.getPicName());
			}
		}
		modelFeature.setListResult(listFeature);
		return modelFeature;
		
		/*
		List<ProductDetailModel> listFeature = productDetailService.findNumberOfMotorFeature(8, "xe đẹp");
		PictureModel modelpicfeature = new PictureModel();
		
		for (ProductDetailModel o : listFeature) {

			modelpicfeature = PictureService.findOneByAmotorId(o.getaMotorId());
			if (modelpicfeature != null) {
				o.setPicName(modelpicfeature.getPicName());
			}

		}
		modelFeature.setListResult(listFeature);
		return modelFeature;
		*/
	}
	
	private ProductDetailModel showFirstProduct(ProductDetailModel firstProduct, IterableList<ProductDetailModel> list2) {
		PictureModel model4 = new PictureModel();
		Iterator<ProductDetailModel> it = list2.iterator();
		while(it.hasNext()) {
			ProductDetailModel temp = it.next();
			model4 = PictureService.findOneByAmotorId(temp.getaMotorId());
			if (model4 != null) {
				temp.setPicName(model4.getPicName());
			}
		}
		firstProduct.setListResult(list2);
		return firstProduct;
		
		/*
		PictureModel model4 = new PictureModel();
		for (ProductDetailModel o : list2) {
			model4 = PictureService.findOneByAmotorId(o.getaMotorId());
			if (model4 != null) {
				o.setPicName(model4.getPicName());
			}

		}
		firstProduct.setListResult(list2);
		return firstProduct;
		*/
	}
	
	
	private ProductDetailModel showSlideProduct(ProductDetailModel slideProduct, IterableList<ProductDetailModel> list2) {
		
		Iterator<ProductDetailModel> it = list2.iterator();
		while(it.hasNext()) {
			ProductDetailModel temp = it.next();
			slideProduct.setPicName(temp.getPicName());
			slideProduct.setMotors_Name(temp.getMotors_Name());
			slideProduct.setMotorsDecs(temp.getMotorsDecs());
			slideProduct.setaMotorId(temp.getaMotorId());
			list2.remove(0);
			break;
		}
		return slideProduct;
		
		/*
		
		for (ProductDetailModel o : list2) {
			slideProduct.setPicName(o.getPicName());
			slideProduct.setMotors_Name(o.getMotors_Name());
			slideProduct.setMotorsDecs(o.getMotorsDecs());
			slideProduct.setaMotorId(o.getaMotorId());
			list2.remove(0);
			break;
		}
		return slideProduct;
		*/
	}
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("name") != null && session.getAttribute("role") == "user") {
			SystemStaticVariables.State = "ActiveState";
		}
		System.out.println(SystemStaticVariables.State);

		// First product in home
		IterableList<ProductDetailModel> list2 = new IterableList<ProductDetailModel>(productDetailService.findNumberOfMotor(3));
		ProductDetailModel model3 = new ProductDetailModel();
		model3 = showFirstProduct(model3, list2);
		//Show product in slide
		ProductDetailModel model5 = new ProductDetailModel();
		model5 = showSlideProduct(model5, list2);
		request.setAttribute("model3", model3);
		request.setAttribute("model5", model5);
		
		
		
		// feature product
		ProductDetailModel modelFeature = new ProductDetailModel();
		modelFeature = showFeatureProduct(modelFeature);
		request.setAttribute("modelFeature", modelFeature);
		for (ProductDetailModel i : modelFeature.listResult1.getArrayList())
		{
			System.out.println(i.getPicName());
		}
		
		
		// recent product
		ProductDetailModel model = new ProductDetailModel();
		model = showRecentProduct(model);
		request.setAttribute("model", model);


		// show number favor in the header 
		favoriteModel favor = new favoriteModel();
		Cookie[] listCookie = request.getCookies();
		favor = detailsOnNavBar.showFavoriteProductNum(favor, listCookie);
		request.setAttribute("favorite", favor);
		
		
		//show number cart items in the header 
		
		CartModel cartModel = new CartModel();
		cartModel = detailsOnNavBar.showCartNum(session, cartModel);
		
		request.setAttribute("cart", cartModel);
		
		//show home page view 
		RequestDispatcher rd = request.getRequestDispatcher("views/web/home.jsp");
		rd.forward(request, response);
		
		
		/*
//		response.addHeader("Content-Security-Policy", "default-src 'self'");
		HttpSession session = request.getSession();
		if (session.getAttribute("name") != null && session.getAttribute("role") == "user") {
			SystemStaticVariables.State = "ActiveState";
		}
		System.out.println(SystemStaticVariables.State);

		// First product in home
		List<ProductDetailModel> list2 = productDetailService.findNumberOfMotor(3);
		ProductDetailModel model3 = new ProductDetailModel();
		model3 = showFirstProduct(model3, list2);
		//Show product in slide
		ProductDetailModel model5 = new ProductDetailModel();
		model5 = showSlideProduct(model5, list2);
		request.setAttribute("model3", model3);
		request.setAttribute("model5", model5);
		
		
		
		// feature product
		ProductDetailModel modelFeature = new ProductDetailModel();
		modelFeature = showFeatureProduct(modelFeature);
		request.setAttribute("modelFeature", modelFeature);
		
		
		// recent product
		ProductDetailModel model = new ProductDetailModel();
		model = showRecentProduct(model);
		request.setAttribute("model", model);


		// show number favor in the header 
		favoriteModel favor = new favoriteModel();
		Cookie[] listCookie = request.getCookies();
		favor = detailsOnNavBar.showFavoriteProductNum(favor, listCookie);
		request.setAttribute("favorite", favor);
		
		
		//show number cart items in the header 
		
		CartModel cartModel = new CartModel();
		cartModel = detailsOnNavBar.showCartNum(session, cartModel);
		
		request.setAttribute("cart", cartModel);
		
		//show home page view 
		RequestDispatcher rd = request.getRequestDispatcher("views/web/home.jsp");
		rd.forward(request, response);
		*/
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
