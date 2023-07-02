package com.MotorbikeStore.controller.web.showDetailsOnPageController.filterController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.model.PictureModel;
import com.MotorbikeStore.model.ProductDetailModel;
import com.MotorbikeStore.service.IPictureService;
import com.MotorbikeStore.service.IProductDetailService;


@WebServlet("/filterMix")
public class filterMixController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductDetailService productDetailService;
	@Inject 
	private IPictureService PictureService;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idbutton = request.getParameter("id"); 
		String branchstr = request.getParameter("branch"); 
		String colorstr = request.getParameter("color");
		String firstPriceStr = request.getParameter("firstPrice");
		String seconPriceStr = request.getParameter("secondPrice");
		String firstCCStr = request.getParameter("firstCC");
		String seconCCStr = request.getParameter("secondCC");
		String numberMotorstr = request.getParameter("numberMotor");
		
		
		
		// compare with cookie 
		Cookie[] listCookie = request.getCookies();
		String branchCookie ="";
		String colorCookie ="";
		String firstPriceCookie ="";
		String seconPriceCookie ="";
		String firstCCCookie ="";
		String seconCCCookie ="";
		String numberMotorCookie = "";
		
		if(listCookie != null) {
			for(Cookie o: listCookie) {
				if(o.getName().equals("branch")) {
					branchCookie += o.getValue();
					
					
				}
				if(o.getName().equals("color")) {
					colorCookie += o.getValue();
					
				}
				if(o.getName().equals("firstPrice")) {
					firstPriceCookie += o.getValue();
					
				}
				if(o.getName().equals("secondPrice")) {
					seconPriceCookie += o.getValue();
					
				}
				if(o.getName().equals("firstCC")) {
					firstCCCookie += o.getValue();
					
				}
				if(o.getName().equals("secondCC")) {
					seconCCCookie += o.getValue();
					
				}
				if(o.getName().equals("numberMotor")) {
					numberMotorCookie += o.getValue();
					
				}
			}
		}
		if(firstPriceStr != null && seconPriceStr != null) {
			if(firstPriceStr != firstPriceCookie && seconPriceStr != seconPriceCookie) {
				firstPriceCookie = firstPriceStr;
				seconPriceCookie = seconPriceStr;
			}
		}
		
		if(colorstr != null) {
			if(colorstr != colorCookie) {
				colorCookie = colorstr;
			}
		}
		if(branchstr != null) {
			if(branchstr != branchCookie) {
				branchCookie = branchstr;
			}
		}
		if(firstCCStr != null && seconCCStr != null ) {
			if(firstCCStr != firstCCCookie && seconCCStr != seconCCCookie ) {
				firstCCCookie = firstCCStr;
				seconCCCookie = seconCCStr;
			}
		}
		if(numberMotorstr != null) {
			if(numberMotorstr != numberMotorCookie) {
				numberMotorCookie = numberMotorstr;
			}
		}
		
		
		
		int firstPrice = 0;
		int seconPrice = 0;
		
		int firstCC = 0; 
		int secondCC = 0; 
		String color = "all";
		String branch = "all";
		int numberMotor = 0;
		if(firstPriceStr != null && seconPriceStr != null ) {
			firstPrice = Integer.parseInt(firstPriceStr);
			seconPrice = Integer.parseInt(seconPriceStr);
		}
		
		if(firstCCStr != null && seconCCStr != null) {
			firstCC = Integer.parseInt(firstCCStr);
			secondCC = Integer.parseInt(seconCCStr);
		}
		if(numberMotorstr != null) {
			numberMotor = Integer.parseInt(numberMotorstr);
		}
		if(colorstr != null) {
			color = colorstr;
		}
		if(branchstr != null) {
			branch = branchstr;
		}
		if(!idbutton.equals("price")  ) {
			if(firstPriceCookie != "" && seconPriceCookie != "") {
				firstPrice = Integer.parseInt(firstPriceCookie);
				seconPrice = Integer.parseInt(seconPriceCookie);
			}
			
		}
		if(!idbutton.equals("color") ) {
			if(colorCookie != "" ) {
				color = colorCookie;
			}
		}
		if(!idbutton.equals("branch")) {
			if(branchCookie != "") {
				branch = branchCookie;
			}
		}
		if(!idbutton.equals("speed")) {
			if(!firstCCCookie.equals("")  && !seconCCCookie.equals("")) {
				firstCC = Integer.parseInt(firstCCCookie);
				secondCC = Integer.parseInt(seconCCCookie);
			}
		}
		if(!idbutton.equals("number")) {
			if(!numberMotorCookie.equals("")) {
				numberMotor = Integer.parseInt(numberMotorCookie);
			}
		}
		

		Cookie c1 = new Cookie("firstPrice", firstPriceCookie);
		
		response.addCookie(c1);
		Cookie c2 = new Cookie("secondPrice", seconPriceCookie);
		
		response.addCookie(c2);
		Cookie c3 = new Cookie("color", colorCookie);
		
		response.addCookie(c3);
		Cookie c4 = new Cookie("branch", branchCookie);
		response.addCookie(c4);
		Cookie c5 = new Cookie("firstCC", firstCCCookie);
		response.addCookie(c5);
		Cookie c6 = new Cookie("secondCC", seconCCCookie);
		response.addCookie(c6);
		Cookie c7 = new Cookie("numberMotor", numberMotorCookie);
		response.addCookie(c7);
		
		//List data
		List<ProductDetailModel>  list = new ArrayList<>();

		list = productDetailService.filterMix(firstPrice, seconPrice, color, firstCC, secondCC, branch, numberMotor);
		
		//Load data 
		PictureModel model2 = new PictureModel();
		model2.setPicPath(request.getContextPath() + "/uploads/images/product/");
		for (ProductDetailModel o : list) {

			model2 = PictureService.findOneByAmotorId(o.getaMotorId());
			o.setPicName(model2.getPicName());
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		for (ProductDetailModel o : list) {

			out.println("<div class=\"col-lg-4 col-md-6 col-sm-6 pb-1\">\r\n"
					+ "							<div class=\"product-item bg-light mb-4\">\r\n"
					+ "								<div class=\"product-img position-relative overflow-hidden\">\r\n"
					+ "									<img class=\"img-fluid w-100\" style=\"height: 400px\"\r\n"
					+ "										src=\"/MotorbikeStore/uploads/images/product/"+o.getPicName()+"\"\r\n"
					+ "										alt=\"\">\r\n"
					+ "									<div class=\"product-action\">\r\n"
					+ "\r\n"
					+ "										<a \r\n"
					+ "											class=\"btn btn-outline-dark btn-square btnaddCart\" id=\""+o.getaMotorId()+"\"\r\n"
					+ "											href=\"\" ><i\r\n"
					+ "											class=\"fa fa-shopping-cart\"></i></a> <a\r\n"
					+ "											class=\"btn btn-outline-dark btn-square\"\r\n"
					+ "											href=\"addFavoriteProduct?id="+o.getaMotorId()+"&idpage=1\"><i\r\n"
					+ "											class=\"far fa-heart\"></i></a> <a\r\n"
					+ "											class=\"btn btn-outline-dark btn-square\"\r\n"
					+ "											href=\"notaddshopDetail?id="+o.getaMotorId()+"\"><i\r\n"
					+ "											class=\"fa fa-search\"></i></a>\r\n"
					+ "									</div>\r\n"
					+ "								</div>\r\n"
					+ "								<div class=\"text-center py-4\">\r\n"
					+ "									<a class=\"h6 text-decoration-none text-truncate\">"+o.getMotors_Name()+"</a>\r\n"
					+ "									<div\r\n"
					+ "										class=\"d-flex align-items-center justify-content-center mt-2\">\r\n"
					+ "										<h5>$ "+o.getPrice()+"</h5>\r\n"
					+ "										<h6 class=\"text-muted ml-2\">\r\n"
					+ "											<del>$ "+o.getPrice()+"</del>\r\n"
					+ "										</h6>\r\n"
					+ "									</div>\r\n"
					+ "									<div\r\n"
					+ "										class=\"d-flex align-items-center justify-content-center mb-1\">\r\n"
					+ "										<small class=\"fa fa-star text-primary mr-1\"></small> <small\r\n"
					+ "											class=\"fa fa-star text-primary mr-1\"></small> <small\r\n"
					+ "											class=\"fa fa-star text-primary mr-1\"></small> <small\r\n"
					+ "											class=\"fa fa-star text-primary mr-1\"></small> <small\r\n"
					+ "											class=\"fa fa-star text-primary mr-1\"></small> <small>(99)</small>\r\n"
					+ "									</div>\r\n"
					+ "								</div>\r\n"
					+ "							</div>\r\n"
					+ "						</div>");

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
