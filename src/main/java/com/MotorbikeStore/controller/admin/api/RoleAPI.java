package com.MotorbikeStore.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.model.roleModel;
import com.MotorbikeStore.service.IRoleService;
import com.MotorbikeStore.utils.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;
@WebServlet(urlPatterns = {"/api-admin-Role"})
public class RoleAPI extends HttpServlet{
	
	
	@Inject
	private IRoleService roleService;
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("application/json");
		
		roleModel rolemodel = HttpUtil.of(request.getReader()).toModel(roleModel.class);
		
		rolemodel = roleService.save(rolemodel);
		
		
		
		mapper.writeValue(response.getOutputStream(), rolemodel);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		roleModel updateRolemodel = HttpUtil.of(request.getReader()).toModel(roleModel.class);
		updateRolemodel = roleService.update(updateRolemodel);
		
		
		
		
		mapper.writeValue(response.getOutputStream(), updateRolemodel);
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		
		roleModel updateRolemodel = HttpUtil.of(request.getReader()).toModel(roleModel.class);
		roleService.delete(updateRolemodel.getRoleIds());
		
		
		mapper.writeValue(response.getOutputStream(), "{}");
	}
	

}
