package com.MotorbikeStore.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.MotorbikeStore.constant.SystemConstant;
import com.MotorbikeStore.model.PictureModel;
import com.MotorbikeStore.service.IPictureService;
import com.MotorbikeStore.utils.FileUtil;

@MultipartConfig
@WebServlet("/admin-addPicture")
public class addPictureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject 
	private IPictureService PictureService;
	int aMotorId1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		aMotorId1 = Integer.parseInt(request.getParameter("id"));
		PictureModel model = new PictureModel();
		model.setListResult(PictureService.findByAMotorId(aMotorId1));
		model.setaMotorId(aMotorId1);
		model.setPicPath(request.getContextPath()+"/uploads/images/product/");
		request.setAttribute("model", model);
		RequestDispatcher rd = request.getRequestDispatcher("views/admin/addPicture.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// upload multiple images
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		

		// Input picture into a upload file
		String fileName = "";
		List<String> listPicture = new ArrayList<String>();
		List<Part> fileParts = request.getParts().stream().filter(part -> "picture".equals(part.getName()))
				.collect(Collectors.toList());
		if (fileParts != null && fileParts.size() > 0 && (fileParts.size() <= 5 || fileParts.size() < 1)) {
			PictureModel newPicture = new PictureModel();
			for (Part filePart : fileParts) {
				fileName = FileUtil.rename(Paths.get(filePart.getSubmittedFileName()).getFileName().toString());
				// InputStream fileContent = filePart.getInputStream();
				// System.out.println("fileContent: "+fileContent);
				if (!"".equals(fileName)) {
					// Get real path of project
					String dirPath = request.getServletContext().getRealPath("") + SystemConstant.DIR_UPLOAD;
					File saveDir = new File(dirPath);
					if (!saveDir.exists()) {
						saveDir.mkdirs();
					}
					String filePath = dirPath + File.separator + fileName;
					filePart.write(filePath);
				}

				// Add to database
				int aMotorId = aMotorId1;
				newPicture.setaMotorId(aMotorId);
				newPicture.setPicName(fileName);
				int addImage = PictureService.save(newPicture);
			}
			response.sendRedirect("admin-addPicture?id="+aMotorId1+"");
		}

	}

}
