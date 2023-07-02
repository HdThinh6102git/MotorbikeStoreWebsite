package com.MotorbikeStore.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.model.specificationModel;
import com.MotorbikeStore.service.ISpecificationService;
import com.MotorbikeStore.utils.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;


@WebServlet("/api-admin-Specification")
public class SpecificationAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
    private ISpecificationService specificationService;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		request.setCharacterEncoding("UTF-8");

		response.setContentType("application/json");
		
		specificationModel specification = HttpUtil.of(request.getReader()).toModel(specificationModel.class);
		
		
		specification = specificationService.save(specification);
		mapper.writeValue(response.getOutputStream(), specification);
	}
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		specificationModel updateSpecificationModel = HttpUtil.of(request.getReader()).toModel(specificationModel.class);
		
		updateSpecificationModel = specificationService.update(updateSpecificationModel);
		
		
		
		
		mapper.writeValue(response.getOutputStream(), updateSpecificationModel);
		
	}
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		specificationModel updateSpecificationModel = HttpUtil.of(request.getReader()).toModel(specificationModel.class);
		
		specificationService.delete(updateSpecificationModel.getMotorsId());
		
		
		mapper.writeValue(response.getOutputStream(), "{}");
		
	}
    
	

	
	

}
