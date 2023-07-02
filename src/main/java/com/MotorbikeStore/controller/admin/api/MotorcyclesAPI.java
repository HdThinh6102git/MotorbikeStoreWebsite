package com.MotorbikeStore.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.model.motorcyclesModel;
import com.MotorbikeStore.service.IMotorcyclesService;
import com.MotorbikeStore.utils.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;

@WebServlet("/api-admin-Motorcycles")
public class MotorcyclesAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IMotorcyclesService motorcyclesService;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		request.setCharacterEncoding("UTF-8");

		response.setContentType("application/json");
		
		motorcyclesModel motorcycles = HttpUtil.of(request.getReader()).toModel(motorcyclesModel.class);
		motorcycles = motorcyclesService.save(motorcycles);
		mapper.writeValue(response.getOutputStream(), motorcycles);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		motorcyclesModel updateMotorcycleModel = HttpUtil.of(request.getReader()).toModel(motorcyclesModel.class);
		
		updateMotorcycleModel = motorcyclesService.update(updateMotorcycleModel);
		
		
		
		
		mapper.writeValue(response.getOutputStream(), updateMotorcycleModel);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		motorcyclesModel updateMotorcycleModel = HttpUtil.of(request.getReader()).toModel(motorcyclesModel.class);
		
		motorcyclesService.delete(updateMotorcycleModel.getMotorsId());
		
		
		mapper.writeValue(response.getOutputStream(), "{}");
	}

}
