package com.MotorbikeStore.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.model.AccountModel;
import com.MotorbikeStore.service.IAccountService;
import com.MotorbikeStore.utils.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;


@WebServlet("/accountAPI")
public class accountAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IAccountService AccountService;
	
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		AccountModel accountmodel = HttpUtil.of(request.getReader()).toModel(AccountModel.class);
		
		AccountService.delete(accountmodel.getUserId());
		
		
		
		
		
		mapper.writeValue(response.getOutputStream(), "{}");
	}
       
    
	
}
