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

import com.MotorbikeStore.service.IMotorcyclesService;


@WebServlet("/admin-addcategory")
public class categoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
    private IMotorcyclesService motorcyclesService;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
     	if(session.getAttribute("name") != null && session.getAttribute("role") == "admin")
     	{
    		RequestDispatcher rd = request.getRequestDispatcher("views/admin/editCategory.jsp");
    		
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
