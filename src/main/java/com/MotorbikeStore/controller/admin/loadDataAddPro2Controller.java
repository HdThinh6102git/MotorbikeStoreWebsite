package com.MotorbikeStore.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.model.specificationModel;
import com.MotorbikeStore.service.ISpecificationService;


@WebServlet("/loadSpecification")
public class loadDataAddPro2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
    private ISpecificationService specificationService;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		specificationModel model = new specificationModel();
		model= specificationService.findOne(id);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<div class=\"form-group mb-3\">\r\n"
				+ "										<label for=\"name\">Size </label> <input id=\"size\" name=\"size\"\r\n"
				+ "											type=\"text\" class=\"form-control validate\" required\r\n"
				+ "											disabled=\"disabled\" value=\""+model.getSize()+"\" />\r\n"
				+ "									</div>\r\n"
				+ "									<div class=\"form-group mb-3\">\r\n"
				+ "										<label for=\"name\">Mass(KG) </label> <input id=\"massKg\"\r\n"
				+ "											name=\"massKg\" type=\"text\" class=\"form-control validate\"\r\n"
				+ "											required disabled=\"disabled\" value=\""+model.getMassKg()+"\" />\r\n"
				+ "									</div>\r\n"
				+ "									<div class=\"form-group mb-3\">\r\n"
				+ "										<label for=\"name\">Height(CM) </label> <input\r\n"
				+ "											id=\"saddleHeightCm\" name=\"saddleHeightCm\" type=\"text\"\r\n"
				+ "											class=\"form-control validate\" required disabled=\"disabled\"\r\n"
				+ "											value=\""+model.getSaddleHeightCm()+"\" />\r\n"
				+ "									</div>\r\n"
				+ "									<div class=\"form-group mb-3\">\r\n"
				+ "										<label for=\"name\">RPM </label> <input id=\"rpm\" name=\"rpm\"\r\n"
				+ "											type=\"text\" class=\"form-control validate\" required\r\n"
				+ "											disabled=\"disabled\" value=\""+model.getRpm()+"\" />\r\n"
				+ "									</div>\r\n"
				+ "									<div class=\"form-group mb-3\">\r\n"
				+ "										<label for=\"name\">Engine Torque </label> <input\r\n"
				+ "											id=\"engineTorque\" name=\"engineTorque\" type=\"text\"\r\n"
				+ "											class=\"form-control validate\" required disabled=\"disabled\"\r\n"
				+ "											value=\""+model.getEngineTorque()+"\" />\r\n"
				+ "									</div>\r\n"
				+ "									<div class=\"form-group mb-3\">\r\n"
				+ "										<label for=\"name\">Horse Power </label> <input id=\"horsePower\"\r\n"
				+ "											name=\"horsePower\" type=\"text\" class=\"form-control validate\"\r\n"
				+ "											required disabled=\"disabled\" value=\""+model.getHorsePower()+"\" />\r\n"
				+ "									</div>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
