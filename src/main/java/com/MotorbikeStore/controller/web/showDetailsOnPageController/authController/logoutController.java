package com.MotorbikeStore.controller.web.showDetailsOnPageController.authController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MotorbikeStore.staticVariable.SystemStaticVariables;

@WebServlet("/logout")
public class logoutController extends HttpServlet
{
		private static final long serialVersionUID = 1L;	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			session.invalidate();
			SystemStaticVariables.State = "InActiveState";
			RequestDispatcher rd = request.getRequestDispatcher("/web-main-page");
			rd.forward(request, response);
		}

}
