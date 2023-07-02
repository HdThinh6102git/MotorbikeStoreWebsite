package com.MotorbikeStore.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.model.commentModel;
import com.MotorbikeStore.service.ICommentService;
import com.MotorbikeStore.utils.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;


@WebServlet("/commentAPI")
public class commentAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ICommentService commentService;
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		commentModel commentmodel = HttpUtil.of(request.getReader()).toModel(commentModel.class);
		
		commentService.delete(commentmodel.getCmtId());
		
		
		
		mapper.writeValue(response.getOutputStream(), "{}");
	}
       
    
	
}
