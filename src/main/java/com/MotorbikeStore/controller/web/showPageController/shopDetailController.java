package com.MotorbikeStore.controller.web.showPageController;

import java.io.IOException;
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
import com.MotorbikeStore.model.PictureModel;
import com.MotorbikeStore.model.ProductDetailModel;
import com.MotorbikeStore.model.commentModel;
import com.MotorbikeStore.model.favoriteModel;
import com.MotorbikeStore.model.reviewModel;
import com.MotorbikeStore.model.specificationModel;
import com.MotorbikeStore.service.ICommentService;
import com.MotorbikeStore.service.IPictureService;
import com.MotorbikeStore.service.IProductDetailService;
import com.MotorbikeStore.service.IReviewService;
import com.MotorbikeStore.service.ISpecificationService;

@WebServlet("/notaddshopDetail")
public class shopDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductDetailService ProductDetailService;
	@Inject
	private IPictureService PictureService;
	@Inject
	private ICommentService commentService;
	@Inject
	private ISpecificationService specificationService;
	@Inject
	private IReviewService reviewService;
	

	@Inject
	private IDetailsOnNavBar detailsOnNavBar;

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//get product clicked and set some information to show
		float moneyPrepaid = 0f;
		int aMotorId = Integer.parseInt(request.getParameter("id"));
		ProductDetailModel model = new ProductDetailModel();
		model = ProductDetailService.findOneByAmotorId(aMotorId);
		moneyPrepaid = model.getPrice() * 0.25f;
		model.setMoneyPrepaid(moneyPrepaid);
		
		
		// show specification and product detail
		specificationModel modelSpe = new specificationModel();
		modelSpe = specificationService.findOne(model.getMotorsId());
		request.setAttribute("model", model);
		PictureModel model2 = new PictureModel();
		PictureModel model3 = new PictureModel();
		List<PictureModel> list = PictureService.findByAMotorId(aMotorId);

		for (PictureModel o : list) {
			model3.setPicName(o.getPicName());
			list.remove(0);
			break;
		}
		model2.setListResult(list);
		request.setAttribute("modelSpe", modelSpe);
		request.setAttribute("model3", model3);
		request.setAttribute("model2", model2);

		// show number favor in the header
		favoriteModel favor = new favoriteModel();
		Cookie[] listCookie = request.getCookies();
		favor = detailsOnNavBar.showFavoriteProductNum(favor, listCookie);
		request.setAttribute("favorite", favor);

		// show number cart items in the header
		HttpSession session = request.getSession();
		CartModel cartModel = new CartModel();
		cartModel = detailsOnNavBar.showCartNum(session, cartModel);
		request.setAttribute("cart", cartModel);

		// Select product also like
		ProductDetailModel modelAlso = new ProductDetailModel();
		PictureModel modelpicAlso = new PictureModel();
		List<ProductDetailModel> listAlso = ProductDetailService.filterBranch(model.getBranch());
		for (ProductDetailModel o : listAlso) {

			modelpicAlso = PictureService.findOneByAmotorId(o.getaMotorId());
			if (modelpicAlso != null) {
				o.setPicName(modelpicAlso.getPicName());
			}

		}
		modelAlso.setListResult(listAlso);
		request.setAttribute("modelAlso", modelAlso);

		// show discussion
		commentModel modelComment = new commentModel();
		commentModel modelComment2 = new commentModel();
		List<commentModel> listComment = commentService.findByaMotorId(aMotorId);
		modelComment2.setQuantity(listComment.size());
		modelComment.setListResult(listComment);

		request.setAttribute("modelComment", modelComment);
		request.setAttribute("modelComment2", modelComment2);

		// show review
		reviewModel modelReview = new reviewModel();
		reviewModel modelReview2 = new reviewModel();
		List<reviewModel> listReview = reviewService.findByaMotorId(aMotorId);
		modelReview2.setQuantity(listReview.size());
		modelReview.setListResult(listReview);
		request.setAttribute("modelReview", modelReview);
		request.setAttribute("modelReview2", modelReview2);

		// show view product detail
		RequestDispatcher rd = request.getRequestDispatcher("views/web/shopDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
