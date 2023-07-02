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

import com.MotorbikeStore.model.paymentDetailModel;
import com.MotorbikeStore.service.IpaymentDetailService;


@WebServlet("/admin-home")
public class adminHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
    private IpaymentDetailService paymentDetailService;
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
     	if(session.getAttribute("name") != null && session.getAttribute("role") == "admin")
     	{
     		paymentDetailModel model = new paymentDetailModel();
     		model.setListResult(paymentDetailService.findAll());
     		
     		request.setAttribute("model", model);
    		rd = request.getRequestDispatcher("views/admin/home.jsp");
    		rd.forward(request, response);

     	}else
     	{
//     			rd = request.getRequestDispatcher("views/Login/login.jsp");
//     			rd.forward(request, response);
     			response.sendRedirect("login");
     	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
