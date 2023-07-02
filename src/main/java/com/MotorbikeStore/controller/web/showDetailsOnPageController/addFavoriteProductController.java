package com.MotorbikeStore.controller.web.showDetailsOnPageController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.constant.SystemConstant;


@WebServlet("/addFavoriteProduct")
public class addFavoriteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int aMotorId = Integer.parseInt(request.getParameter("id"));
		int idpage = Integer.parseInt(request.getParameter("idpage"));
		
		//Lưu cookies 
		Cookie[] listCookie = request.getCookies();
		String valueCartCookie ="";
		if(listCookie != null) {
			for(Cookie o: listCookie) {
				if(o.getName().equals("cart")) {
					valueCartCookie += o.getValue();
					o.setMaxAge(0);
					response.addCookie(o);
				}
			}
		}
		if(valueCartCookie.isEmpty()) {
			valueCartCookie =  Integer.toString(aMotorId) ;
		}else {
			valueCartCookie = valueCartCookie + "/" + Integer.toString(aMotorId);
		}
		Cookie c = new Cookie("cart", valueCartCookie);
		c.setMaxAge(2*24*60*60);
		response.addCookie(c);
		if(idpage == 0) {
			response.sendRedirect("web-main-page");
		}else if(idpage == 1) {
			response.sendRedirect("shop");
		}else if(idpage == 2) {
			response.sendRedirect("notaddshopDetail?id="+aMotorId+"");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
