package com.MotorbikeStore.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.model.AccountModel;
import com.MotorbikeStore.service.IAccountService;


@WebServlet("/admin-editAccount")
public class editAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
    private IAccountService AccountService;
    String stringId ="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		stringId = request.getParameter("id");
		int userId = 0;
		if(!stringId.isEmpty()) {
			userId = Integer.parseInt(stringId);
		}
		AccountModel model = AccountService.findOneByUserId(userId);
		request.setAttribute("model", model);
		RequestDispatcher rd = request.getRequestDispatcher("views/admin/editAccount.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		String email = request.getParameter("email");
		String phoneNumstr = request.getParameter("phoneNum");
		String idCardstr = request.getParameter("idCard");
		int phoneNum = 0;
		int idCard = 0;
		int userId = 0;
		if(!stringId.isEmpty()) {
			userId = Integer.parseInt(stringId);
		}
		if(phoneNumstr != null && idCardstr != null ) {
			phoneNum = Integer.parseInt(phoneNumstr);
			idCard = Integer.parseInt(idCardstr);
		}
		AccountModel model = new AccountModel();
		model.setUserName(userName);
		model.setUserId(userId);
		model.setUserPass(userPass);
		model.setEmail(email);
		model.setPhoneNum(phoneNum);
		model.setIdCard(idCard);
		AccountService.update(model);
		response.sendRedirect("admin-accounts");
		
	}

}
