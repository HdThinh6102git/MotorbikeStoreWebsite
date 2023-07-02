package com.MotorbikeStore.controller.web.showDetailsOnPageController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MotorbikeStore.model.CartModel;
import com.MotorbikeStore.model.ProductDetailModel;
import com.MotorbikeStore.model.customerModel;
import com.MotorbikeStore.model.favoriteModel;
import com.MotorbikeStore.model.paymentModel;
import com.MotorbikeStore.service.ICartService;
import com.MotorbikeStore.service.IProductDetailService;
import com.MotorbikeStore.service.IcustomerService;
import com.MotorbikeStore.service.IpaymentService;
import com.MotorbikeStore.utils.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;

@WebServlet("/order")
public class orderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IpaymentService paymentService;
	@Inject
	private IcustomerService customerService;
	@Inject
	private IProductDetailService productDetailService;
	@Inject
	private ICartService cartService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// show number in favor
		Cookie[] listCookie = request.getCookies();
		String valueCartCookie = "";
		if (listCookie != null) {
			for (Cookie o : listCookie) {
				if (o.getName().equals("cart")) {
					valueCartCookie += o.getValue();

				}
			}
		}
		favoriteModel favor = new favoriteModel();

		if (!valueCartCookie.isEmpty()) {
			String[] listAmotorId = new String[100];
			if (valueCartCookie != null && valueCartCookie.length() != 0) {
				listAmotorId = valueCartCookie.split("/");
			}
			favor.setQuantity(listAmotorId.length);

		}
		request.setAttribute("favorite", favor);

		/////

		
		
		// save customer
		ObjectMapper mapper = new ObjectMapper();

		request.setCharacterEncoding("UTF-8");

		response.setContentType("application/json");
		customerModel customer = HttpUtil.of(request.getReader()).toModel(customerModel.class);
		int cusId = customerService.save(customer);
		// save customer

		HttpSession session = request.getSession();
		String userIdstr = session.getAttribute("userId").toString();
		
		float totalPrice = 0;
		
		int userId = 0;
		
		if (userIdstr != null ) {
			userId = Integer.parseInt(userIdstr);
			
			
		}
		List<CartModel> listCart = cartService.findByUserId(userId);
		
		List<Integer> listAmotorId = new ArrayList<>();
		ProductDetailModel model = new ProductDetailModel();
		List<ProductDetailModel> listProduct = new ArrayList<>();
		CartModel cart = new CartModel();
		cart.setListResult(listCart);
		for (CartModel o : listCart) {
			
			listAmotorId.add(o.getaMotorId());
		}
		paymentModel payment = new paymentModel();

		for (int o : listAmotorId) {
			payment.setPrice(productDetailService.findOneByAmotorId(o).getPrice());
			payment.setCusId(cusId);
			payment.setaMotorId(o);
			paymentService.save(payment);
		}
		float prepaidMoney = 0;
		for (ProductDetailModel o : listProduct) {
			for (CartModel o1 : listCart) {
    			
    			o.setCartId(o1.getCartId());
    			listCart.remove(o1);
    			break;
    		}
			prepaidMoney = o.getPrice() * 0.25f;
			o.setMoneyPrepaid(prepaidMoney);
			totalPrice += prepaidMoney;
		}
		response.sendRedirect("cart?userId="+userId+"");

	}

}
