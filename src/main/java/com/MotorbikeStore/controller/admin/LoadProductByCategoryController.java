package com.MotorbikeStore.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MotorbikeStore.model.ProductDetailModel;
import com.MotorbikeStore.service.IProductDetailService;


@WebServlet("/load")
public class LoadProductByCategoryController extends HttpServlet {
	
	@Inject
	private IProductDetailService productDetailService;  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		  
		
		List<ProductDetailModel> list = productDetailService.findByMotorcyclesID(id);
		response.setCharacterEncoding("UTF-8");
		PrintWriter  out = response.getWriter();
		
		for(ProductDetailModel o: list) {
			
			out.println("<tr>\r\n"
					+ "\r\n"
					+ "										<td><a\r\n"
					+ "											href=\"\" id = \""+o.getaMotorId()+"\"\r\n"
					+ "											class=\"btndeleteProduct\" data-toggle=\"tooltip\" title=\"Delete\"\r\n"
					+ "											class=\"tm-product-delete-link\"> <i\r\n"
					+ "												class=\"far fa-trash-alt tm-product-delete-icon\"></i>\r\n"
					+ "\r\n"
					+ "										</a></td>\r\n"
					+ "										<td><a\r\n"
					+ "											href=\"admin-editProduct?id="+o.getaMotorId()+"&id2="+o.getMotorsId()+"\"\r\n"
					+ "											data-toggle=\"tooltip\" title=\"Update \"\r\n"
					+ "											class=\"tm-product-delete-link\"> <i class=\"fas fa-wrench\"></i>\r\n"
					+ "										</a></td>\r\n"
					+ "										<td><a href=\"admin-addPicture?id="+o.getaMotorId()+"\"\r\n"
					+ "											data-toggle=\"tooltip\" title=\"Add Image\"\r\n"
					+ "											class=\"tm-product-delete-link\"> <i class=\"fa-light fa-file-circle-plus\"></i>\r\n"
					+ "										</a></td>\r\n"
					+ "										<td class=\"tm-product-name\">"+o.getMotors_Name()+"</td>\r\n"
					+ "										<td>"+o.getVersion()+"</td>\r\n"
					+ "										<td>"+o.getMotorType()+"</td>\r\n"
					+ "										<td>"+o.getBranch()+"</td>\r\n"
					+ "										<td>"+o.getStyle()+"</td>\r\n"
					+ "										<td>"+o.getColor()+"</td>\r\n"
					+ "										<td>"+o.getPrice()+"</td>\r\n"
					+ "										<td>"+o.getCheckSold()+"</td>\r\n"
					+ "										<td>"+o.getDate_insert()+"</td>\r\n"
					+ "										\r\n"
					+ "										\r\n"
					+ "										\r\n"
					+ "										\r\n"
					+ "									</tr>");
			
		}
		
		
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
