package com.MotorbikeStore.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.model.PictureModel;
import com.MotorbikeStore.service.IPictureService;
import com.MotorbikeStore.utils.FileUtil;

@WebServlet("/delPictureAPI")
public class delPictureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private IPictureService PictureService;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int picId = Integer.parseInt(request.getParameter("id"));
		
		int aMotorID = Integer.parseInt(request.getParameter("id2"));
		// Kiểm tra nếu có thì xóa trong thư mục
		PictureModel picture = PictureService.findOne(picId);
		String picName = picture.getPicName();
		FileUtil.delFile(picName, request);
		// xóa ở data
		PictureService.del(picId);
		response.sendRedirect("admin-addPicture?id="+aMotorID+"");
	}


	
	

}
