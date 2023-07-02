package com.MotorbikeStore.controller.web.showPageController;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MotorbikeStore.service.impl.forgotPass;

@WebServlet("/forgot")

public class forgotPassController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private forgotPass forgotService = new forgotPass();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("views/Login/forgotPassword.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String email = request.getParameter("email");
		RequestDispatcher dispatcher = null;
		int otpvalue = 0;
		HttpSession mySession = request.getSession();

		if(email!=null || !email.equals("")) 
		{
			otpvalue=forgotService.sendOTP(email);
			if(otpvalue == 0)
			{
				dispatcher = request.getRequestDispatcher("views/Login/forgotPassword.jsp");
				request.setAttribute("status","0");
			}
			else if(otpvalue != -1)
			{
				dispatcher = request.getRequestDispatcher("views/Login/EnterOtp.jsp");
				request.setAttribute("status","success");
				//request.setAttribute("connection", con);
				mySession.setAttribute("otp",otpvalue); 
				mySession.setAttribute("email",email); 
				//request.setAttribute("status", "success");
			}
			else
			{
				dispatcher = request.getRequestDispatcher("views/Login/forgotPassword.jsp");
				request.setAttribute("status","-1");
			}
		}

		dispatcher.forward(request, response);
	}

}
			

