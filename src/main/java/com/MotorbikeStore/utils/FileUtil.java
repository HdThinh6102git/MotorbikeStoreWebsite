package com.MotorbikeStore.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.MotorbikeStore.constant.SystemConstant;

public class FileUtil {
	public static String rename(String fileName) {
		String nameFile = "";
		if (!fileName.isEmpty()) {
			String[] arrImg = fileName.split("\\.");
			String duoiFileImg = arrImg[arrImg.length - 1];
			
			for (int i = 0; i < (arrImg.length - 1); i++) {
				if (i == 0) {
					nameFile = arrImg[i];
				} else {
					nameFile += "-" + arrImg[i];
				}
			}
			nameFile = nameFile + "-" + System.nanoTime() + "." + duoiFileImg;
		}
		return nameFile;
	}

	public static String getName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
	//method upload file
	public static String upload(String nameInput, HttpServletRequest request)
			throws ServletException, IOException {
		Part part = request.getPart(nameInput);
		String fileName = rename(part.getSubmittedFileName());
		if(!"".equals(fileName)) {
			
			String dirPath = request.getServletContext().getRealPath("")+ SystemConstant.DIR_UPLOAD;
			File saveDir = new File(dirPath);
			if(!saveDir.exists()) {
				saveDir.mkdirs();
			}
			String filePath = dirPath + File.separator + fileName;
			part.write(filePath);
		}
		return fileName;
	}
	//upload multiple file
	
	// xóa file ảnh đã có trong thư mục
	public static boolean delFile(String fileName, HttpServletRequest request) {
		if(!"".equals(fileName)) {
			String filePart = request.getServletContext().getRealPath("")+
					SystemConstant.DIR_UPLOAD + File.separator + fileName;
			File file = new File(filePart);
			file.delete();
		}
		return false;
	}
}
