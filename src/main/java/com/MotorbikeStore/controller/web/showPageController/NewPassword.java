 package com.MotorbikeStore.controller.web.showPageController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MotorbikeStore.service.impl.resetPasswordService;

/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/newPassword")
public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	resetPasswordService rPass = new resetPasswordService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String newPassword = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");
		// Check Pass bang nhau
		
		RequestDispatcher dispatcher = null;
		if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {
			if(newPassword.equals(confPassword)) {
				String email = session.getAttribute("email").toString();
				try {
					
	
					int rowCount = rPass.resetPassword(newPassword,email);
					if (rowCount > 0) {
						request.setAttribute("status", "resetSuccess");
						 response.sendRedirect(request.getContextPath() + "/web-main-page");
					} else {
						request.setAttribute("status", "resetFailed");
						 response.sendRedirect(request.getContextPath() + "/web-main-page");
					}
					dispatcher.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else {
				request.setAttribute("status", "notSame");
				dispatcher = request.getRequestDispatcher("views/login/newPassword.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
