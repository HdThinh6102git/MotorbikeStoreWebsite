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

import com.MotorbikeStore.service.IRegisService;

@WebServlet("/regist")
public class registController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private IRegisService regisService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("views/Login/regist.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String uname = request.getParameter("name");
		String email = request.getParameter("email");
		String repass = request.getParameter("re_pass");
		String upass = request.getParameter("pass");
		String phone = request.getParameter("contact");
		String cccd = request.getParameter("cccd");
		HttpSession mySession = request.getSession();

		if(email!=null || !email.equals("")) 
		{
			try
			{	
				RequestDispatcher dispatcher = request.getRequestDispatcher("views/Login/regist.jsp");
	
				if(upass.equals(repass))
				{
					int rowCount = regisService.regisUser(upass,uname,cccd,phone,email);
					//neu them dl thanh cong 
					if (rowCount > 0)
					{
						request.setAttribute("status", "success");
					}
					else if(rowCount == 0)
					{
						request.setAttribute("status", "failed");
		
					}
					else
					{
						request.setAttribute("status", "existMailOrCCCD");

					}
				}else
				{
					request.setAttribute("status", "repass");
				}
				dispatcher.forward(request, response);
				
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
	}
}


