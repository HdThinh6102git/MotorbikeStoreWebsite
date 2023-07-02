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

import com.MotorbikeStore.model.motorcyclesModel;
import com.MotorbikeStore.service.IMotorcyclesService;


@WebServlet("/admin-addProduct")
public class addProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IMotorcyclesService motorcyclesService;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
     	if(session.getAttribute("name") != null && session.getAttribute("role") == "admin")
     	{
    		motorcyclesModel model1 = new motorcyclesModel();
    		model1.setListResult(motorcyclesService.findName());
    		request.setAttribute("model1", model1);
    		
    		 rd = request.getRequestDispatcher("views/admin/addProduct.jsp");
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
