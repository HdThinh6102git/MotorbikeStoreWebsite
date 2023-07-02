package com.MotorbikeStore.controller.web.showDetailsOnPageController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.constant.SystemConstant;
import com.MotorbikeStore.model.CartModel;


@WebServlet("/DeleteItemOfCart")
public class DeleteItemOfCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tempId = request.getParameter("id");
		List<Integer> listIdCookie  = new ArrayList<>();
		int aMotorId = 0;
		if(!tempId.isEmpty()) {
			aMotorId = Integer.parseInt(request.getParameter("id"));
		
		Cookie[] listCookie = request.getCookies();
		CartModel cart = new CartModel();
		
			String valueCartCookie = "";
			if(listCookie != null) {
				for(Cookie o: listCookie) {
					if(o.getName().equals("cart")) {
						valueCartCookie += o.getValue();
						
					}
				}
				
			}
			
			if(!valueCartCookie.isEmpty()) {
				
				String[] listAmotorId = new String[100];
				if(valueCartCookie != null && valueCartCookie.length() != 0 ) {
					listAmotorId = valueCartCookie.split("/");
				}
				List<String> templistAmotorId = new ArrayList<String>(Arrays.asList(listAmotorId));
				
				templistAmotorId.remove(Integer.toString(aMotorId));
				valueCartCookie = "";
				for(String item: templistAmotorId) {
					if(valueCartCookie.isEmpty()) {
						valueCartCookie += item;
					}else {
						valueCartCookie = valueCartCookie + "/" + item;
					}
				}
				
				for(Cookie o: listCookie) {
					if(o.getName().equals("cart")) {
						o.setMaxAge(0);
						response.addCookie(o);
						
					}
				}
				Cookie c = new Cookie("cart", valueCartCookie);
				c.setMaxAge(2*24*60*60);
				response.addCookie(c);

				//chuyen doi qua string va dua lai cookie
				
			}
		}
			
		response.sendRedirect("like");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
