package com.MotorbikeStore.controller.web.showPageController;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MotorbikeStore.model.userModel;
import com.MotorbikeStore.service.ILoginService;
import com.MotorbikeStore.staticVariable.SystemStaticVariables;

@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ILoginService userService;
	String idpagestr = "";
	String amotorIdstr = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		amotorIdstr = request.getParameter("id2");
		idpagestr = request.getParameter("id1");
		RequestDispatcher rd = request.getRequestDispatcher("views/Login/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String umail = request.getParameter("email");
		String upass = request.getParameter("password");

		int idpage = 0;
		if (idpagestr != null) {
			idpage = Integer.parseInt(idpagestr);
		}

		int aMotorId = 0;
		if (amotorIdstr != null) {
			aMotorId = Integer.parseInt(amotorIdstr);
		}

		HttpSession session = request.getSession();
		userModel model = new userModel();
		RequestDispatcher dispatcher = null;

		model = userService.login(umail, upass);
		if (model != null) {
			SystemStaticVariables.State = "ActiveState";

			if (model.getRoleId() == 1) {
				if (idpage == 10) {
					response.sendRedirect(request.getContextPath() + "/notaddshopDetail?id=" + aMotorId + "");
					session.setAttribute("userId", model.getUserId());
					session.setAttribute("name", model.getEmail());
					session.setAttribute("role", model.getRoleId() == 1 ? "user" : "admin");
				}else if(idpage == 1) {
					response.sendRedirect(request.getContextPath() + "/shop");
					session.setAttribute("userId", model.getUserId());
					session.setAttribute("name", model.getEmail());
					session.setAttribute("role", model.getRoleId() == 1 ? "user" : "admin");
				}else if(idpage == 2) {
					response.sendRedirect(request.getContextPath() + "/notaddshopDetail?id=" + aMotorId + "");
					session.setAttribute("userId", model.getUserId());
					session.setAttribute("name", model.getEmail());
					session.setAttribute("role", model.getRoleId() == 1 ? "user" : "admin");
				}
				
				
				else {
					response.sendRedirect(request.getContextPath() + "/web-main-page");
					session.setAttribute("userId", model.getUserId());
					session.setAttribute("name", model.getEmail());
					session.setAttribute("role", model.getRoleId() == 1 ? "user" : "admin");
				}

			} else if (model.getRoleId() == 2) {
				response.sendRedirect(request.getContextPath() + "/admin-home");
				session.setAttribute("name", model.getEmail());
				session.setAttribute("role", model.getRoleId() == 1 ? "user" : "admin");
			}

		} else {
			request.setAttribute("status", "failed");
			dispatcher = request.getRequestDispatcher("views/Login/login.jsp");
			dispatcher.forward(request, response);
			// response.sendRedirect(request.getContextPath() + "/login?action=login");

		}

	}
}
