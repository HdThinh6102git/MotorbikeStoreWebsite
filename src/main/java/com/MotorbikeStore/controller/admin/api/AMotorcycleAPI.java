package com.MotorbikeStore.controller.admin.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.model.PictureModel;
import com.MotorbikeStore.model.ProductDetailModel;
import com.MotorbikeStore.model.a_MotorcycleModel;
import com.MotorbikeStore.service.IPictureService;
import com.MotorbikeStore.service.IaMotorcycleService;
import com.MotorbikeStore.utils.FileUtil;
import com.MotorbikeStore.utils.HttpUtil;

import org.codehaus.jackson.map.ObjectMapper;


@WebServlet("/api-admin-aMotorcycle")
public class AMotorcycleAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
    private IaMotorcycleService aMotorcycleService;
    @Inject
    private IPictureService PictureService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("application/json");
		
		a_MotorcycleModel aMotorcycle = HttpUtil.of(request.getReader()).toModel(a_MotorcycleModel.class);
		
		aMotorcycle = aMotorcycleService.save(aMotorcycle);
			
		mapper.writeValue(response.getOutputStream(), aMotorcycle);
		
		
		
		
		
		
		
	}



	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		a_MotorcycleModel updateAmotorcycleModel = HttpUtil.of(request.getReader()).toModel(a_MotorcycleModel.class);
		
		updateAmotorcycleModel = aMotorcycleService.update(updateAmotorcycleModel);
		
		
		
		
		mapper.writeValue(response.getOutputStream(), updateAmotorcycleModel);
	}



	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		a_MotorcycleModel updateAmotorcycleModel = HttpUtil.of(request.getReader()).toModel(a_MotorcycleModel.class);
		aMotorcycleService.delete(updateAmotorcycleModel.getaMotorId());
		List<PictureModel> listPic = PictureService.findByAMotorId(updateAmotorcycleModel.getaMotorId());
		for(PictureModel o: listPic) {
			String picName = o.getPicName();
			FileUtil.delFile(picName, request);
			// xóa ở data
			PictureService.del(o.getPicId());
		}
		
		
		
		
		
		
		mapper.writeValue(response.getOutputStream(), "{}");
	}
	

}
