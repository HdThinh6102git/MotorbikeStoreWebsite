package com.MotorbikeStore.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MotorbikeStore.model.a_MotorcycleModel;
import com.MotorbikeStore.model.motorcyclesModel;
import com.MotorbikeStore.model.specificationModel;
import com.MotorbikeStore.service.IMotorcyclesService;
import com.MotorbikeStore.service.ISpecificationService;
import com.MotorbikeStore.service.IaMotorcycleService;


@WebServlet("/admin-editProduct")
public class editProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IMotorcyclesService motorcyclesService;
	@Inject
	private ISpecificationService specificationService;
	@Inject
	private IaMotorcycleService aMotorcycleService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
     	if(session.getAttribute("name") != null && session.getAttribute("role") == "admin")
     	{
     		int id = Integer.parseInt(request.getParameter("id"));
    		int id2 = Integer.parseInt(request.getParameter("id2"));
    		
    		
    		motorcyclesModel model1 = new motorcyclesModel();
    		model1.setListResult(motorcyclesService.findName());
    		request.setAttribute("model1", model1);
    		
    		motorcyclesModel model2 = new motorcyclesModel();
    		model2 = motorcyclesService.findOneById(id2);
    		request.setAttribute("model2", model2);
    		
    		
    		specificationModel model3 = new specificationModel();
    		model3= specificationService.findOne(id2);
    		request.setAttribute("model3", model3);
    		
    		a_MotorcycleModel model4 = new a_MotorcycleModel();
    		model4= aMotorcycleService.findOne(id);
    		request.setAttribute("model4", model4);
    		
    		RequestDispatcher rd = request.getRequestDispatcher("views/admin/addProduct.jsp");
    		rd.forward(request, response);

     	}else
     	{
     			response.sendRedirect(request.getContextPath()+ "/login");
     	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
