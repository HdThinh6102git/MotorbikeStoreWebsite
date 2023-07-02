package com.MotorbikeStore.controller.web.showDetailsOnPageController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.model.PictureModel;
import com.MotorbikeStore.model.ProductDetailModel;
import com.MotorbikeStore.service.IPictureService;
import com.MotorbikeStore.service.IProductDetailService;

@WebServlet("/showNumProduct")
public class showNumProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductDetailService productDetailService;
	@Inject
	private IPictureService PictureService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idShowStr = request.getParameter("id");
		int idShow = 0;
		if (idShowStr != null) {
			idShow = Integer.parseInt(idShowStr);
		}
		List<ProductDetailModel> list = productDetailService.findAll();
		if (idShow == 0) {
			list = productDetailService.findAll();
		} else if (idShow == 1) {
			list = productDetailService.findNumberOfMotor(5);
		} else if (idShow == 2) {
			list = productDetailService.findNumberOfMotor(10);
		} else if (idShow == 3) {
			list = productDetailService.findNumberOfMotor(20);
		}

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
					+ "						<div class=\"product-item bg-light mb-4\">\r\n"
					+ "							<div class=\"product-img position-relative overflow-hidden\">\r\n"
					+ "								<img class=\"img-fluid w-100\" style=\"height: 400px\" src=\"/MotorbikeStore/uploads/images/product/"
					+ o.getPicName() + "\"\r\n" + "									alt=\"\">\r\n"
					+ "								<div class=\"product-action\">\r\n" + "\r\n" + "\r\n"
					+ "									<a class=\"btn btn-outline-dark btn-square\"\r\n"
					+ "										id=\"" + o.getaMotorId() + "\"\r\n"
					+ "										href=\"addCart?id=" + o.getaMotorId() + "&idpage=1\"><i\r\n"
					+ "										class=\"fa fa-shopping-cart\"></i></a> <a\r\n"
					+ "										class=\"btn btn-outline-dark btn-square\" href=\"\"><i\r\n"
					+ "										class=\"far fa-heart\"></i></a> <a\r\n"
					+ "										class=\"btn btn-outline-dark btn-square\"\r\n"
					+ "										href=\"notaddshopDetail?id=" + o.getaMotorId() + "\"><i\r\n"
					+ "										class=\"fa fa-search\"></i></a>\r\n"
					+ "								</div>\r\n" + "							</div>\r\n"
					+ "							<div class=\"text-center py-4\">\r\n"
					+ "								<a class=\"h6 text-decoration-none text-truncate\" href=\"\">"
					+ o.getMotors_Name() + "</a>\r\n" + "								<div\r\n"
					+ "									class=\"d-flex align-items-center justify-content-center mt-2\">\r\n"
					+ "									<h5>$ " + o.getPrice() + "</h5>\r\n"
					+ "									<h6 class=\"text-muted ml-2\">\r\n"
					+ "										<del>$ " + o.getPrice() + "</del>\r\n"
					+ "									</h6>\r\n" + "								</div>\r\n"
					+ "								<div\r\n"
					+ "									class=\"d-flex align-items-center justify-content-center mb-1\">\r\n"
					+ "									<small class=\"fa fa-star text-primary mr-1\"></small> <small\r\n"
					+ "										class=\"fa fa-star text-primary mr-1\"></small> <small\r\n"
					+ "										class=\"fa fa-star text-primary mr-1\"></small> <small\r\n"
					+ "										class=\"fa fa-star text-primary mr-1\"></small> <small\r\n"
					+ "										class=\"fa fa-star text-primary mr-1\"></small> <small>(99)</small>\r\n"
					+ "								</div>\r\n" + "							</div>\r\n"
					+ "						</div>\r\n" + "					</div>");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
