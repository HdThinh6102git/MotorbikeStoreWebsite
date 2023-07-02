package com.MotorbikeStore.controller.web.showPageController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MotorbikeStore.controller.web.showDetailsOnPageController.showDetailsOnNavBar.IDetailsOnNavBar;
import com.MotorbikeStore.model.CartModel;
import com.MotorbikeStore.model.ProductDetailModel;
import com.MotorbikeStore.model.favoriteModel;
import com.MotorbikeStore.model.paymentDetailModel;
import com.MotorbikeStore.service.ICartService;
import com.MotorbikeStore.service.IProductDetailService;

@WebServlet("/cart")
public class cartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductDetailService productDetailService;
	@Inject
	private ICartService cartService;
	@Inject
	private IDetailsOnNavBar detailsOnNavBar;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	
		
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
     	if(session.getAttribute("name") != null && session.getAttribute("role") == "user")
     	{
     		
     		//show number favor product in the header 
			

     		Cookie[] listCookie = request.getCookies();
			favoriteModel favor = new favoriteModel();
			favor = detailsOnNavBar.showFavoriteProductNum(favor, listCookie);
			request.setAttribute("favorite", favor);
			

     		
     		//
			
     		String userIdstr = request.getParameter("userId");
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
    		float totalPrice = 0;
    		float prepaidMoney = 0f;
    		
    		
    		for (int o : listAmotorId) {

    			listProduct.add(productDetailService.findOneByAmotorId(o));
    		}

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
    		

    		cart.setQuantity(listAmotorId.size());
    		model.setListResult(listProduct);

    		request.setAttribute("model", model);

    		cart.setTotalPrice(totalPrice);

    		request.setAttribute("cart", cart);
    		
    		rd = request.getRequestDispatcher("views/web/cart.jsp");
    		rd.forward(request, response);

     	}else
     	{

     			response.sendRedirect("login");
     	}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
