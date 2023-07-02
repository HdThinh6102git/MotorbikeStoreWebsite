package com.MotorbikeStore.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.model.paymentModel;
import com.MotorbikeStore.service.IpaymentService;


@WebServlet("/admin-editPayment")
public class editPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IpaymentService paymentService;
	String stringId ="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		stringId = request.getParameter("id");
		int paymentId = 0;
		if(!stringId.isEmpty()) {
			paymentId = Integer.parseInt(stringId);
		}
		
		paymentModel model = paymentService.findOneById(paymentId);
		request.setAttribute("model", model);
		RequestDispatcher rd = request.getRequestDispatcher("views/admin/editPayment.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String moneyPrepaidStr = request.getParameter("moneyPrepaid");
		Float moneyPrepaid  =0f;
		if(moneyPrepaidStr != null) {
			moneyPrepaid = Float.parseFloat(moneyPrepaidStr);  
		}
		int paymentId = 0;
		if(!stringId.isEmpty()) {
			paymentId = Integer.parseInt(stringId);
		}
		paymentModel model = new paymentModel();
		model.setMoneyPrepaid(moneyPrepaid);
		model.setPaymentId(paymentId);
		paymentService.update(model);
		response.sendRedirect("admin-home");
	}

}
