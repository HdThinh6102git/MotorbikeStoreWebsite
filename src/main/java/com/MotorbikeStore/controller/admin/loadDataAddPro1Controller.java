package com.MotorbikeStore.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.model.motorcyclesModel;
import com.MotorbikeStore.service.IMotorcyclesService;


@WebServlet("/loadMotorcycles")
public class loadDataAddPro1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IMotorcyclesService motorcyclesService;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		motorcyclesModel model = new motorcyclesModel();
		model = motorcyclesService.findOneById(id);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<input id=\"motorsId\"\r\n"
				+ "								name=\"motorsId\" type=\"hidden\" class=\"form-control validate\"\r\n"
				+ "								required disabled=\"disabled\" value=\""+model.getMotorsId()+"\" />");
		out.println("<div class=\"form-group mb-3\">\r\n"
				+ "										<label for=\"name\">Product Name </label> <input id=\"name\"\r\n"
				+ "											name=\"name\" type=\"text\" class=\"form-control validate\"\r\n"
				+ "											required disabled=\"disabled\" value=\""+model.getMotors_Name()+"\" />\r\n"
				+ "									</div>\r\n"
				+ "									<div class=\"form-group mb-3\">\r\n"
				+ "										<label for=\"name\">Version </label> <input id=\"name\"\r\n"
				+ "											name=\"name\" type=\"text\" class=\"form-control validate\"\r\n"
				+ "											required disabled=\"disabled\" value=\""+model.getVersion()+"\" />\r\n"
				+ "									</div>\r\n"
				+ "									<div class=\"form-group mb-3\">\r\n"
				+ "										<label for=\"name\">Type </label> <input id=\"name\" name=\"name\"\r\n"
				+ "											type=\"text\" class=\"form-control validate\" required disabled=\"disabled\"\r\n"
				+ "											value=\""+model.getMotorType()+"\" />\r\n"
				+ "									</div>\r\n"
				+ "\r\n"
				+ "									<div class=\"form-group mb-3\">\r\n"
				+ "										<label for=\"name\">Branch </label> <input id=\"name\" name=\"name\"\r\n"
				+ "											type=\"text\" class=\"form-control validate\" required disabled=\"disabled\"\r\n"
				+ "											value=\""+model.getBranch()+"\" />\r\n"
				+ "									</div>\r\n"
				+ "									<div class=\"form-group mb-3\">\r\n"
				+ "										<label for=\"name\">Style </label> <input id=\"name\" name=\"name\"\r\n"
				+ "											type=\"text\" class=\"form-control validate\" required disabled=\"disabled\"\r\n"
				+ "											value=\""+model.getStyle()+"\" />\r\n"
				+ "									</div>\r\n"
				+ "									<div class=\"form-group mb-3\">\r\n"
				+ "										<label for=\"description\">Description</label>\r\n"
				+ "										<textarea class=\"form-control validate\" rows=\"3\"disabled=\"disabled\" required>"+model.getMotors_decs()+"</textarea>\r\n"
				+ "									</div>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
