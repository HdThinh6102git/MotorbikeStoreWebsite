package com.MotorbikeStore.controller.web.showDetailsOnPageController;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MotorbikeStore.model.commentModel;
import com.MotorbikeStore.model.reviewModel;
import com.MotorbikeStore.service.ICommentService;
import com.MotorbikeStore.service.IReviewService;

@WebServlet("/review")
public class reviewController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Inject
    private ICommentService commentService;
    private IReviewService reviewService;
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String aMotorIdStr = request.getParameter("aMotorId");
        
        if(session.getAttribute("name") != null && session.getAttribute("role").equals("user")) {
            // L?y giá tr? ??u vào t? ng??i dùng và ki?m tra ?? ng?n ch?n t?n công XSS và l?u ?o?n review vào c? s? d? li?u
            
            String message = request.getParameter("message");
            
            if (message !=null && !message.isEmpty() && !message.contains("<") && !message.contains(">") && !message.contains("</")) {
                // N?u ?o?n review không ch?a các ký t? <, >, </ thì l?u ?o?n review vào c? s? d? li?u
                commentModel model = new commentModel();
            	//reviewModel model1 = new reviewModel();
            	//model1.setRvDesc(message);
                model.setCmtDecs(message);
    
                if (aMotorIdStr != null) {
                    model.setaMotorId(Integer.parseInt(aMotorIdStr));
//                    model1.setaMotorId(Integer.parseInt(aMotorIdStr));
                }
                
                String userIdStr = request.getParameter("userId");
                if (userIdStr != null) {
                    model.setUserId(Integer.parseInt(userIdStr));
                    //model1.setUserId(Integer.parseInt(userIdStr));
                }
                
                
                commentService.save(model);
                //reviewService.save(model1);
                
                // Hi?n th? thông báo thành công
                request.setAttribute("success", "Bình lu?n c?a b?n ?ã ???c l?u thành công.");
                
            } else {
                // Hi?n th? thông báo l?i n?u ?o?n review ch?a các ký t? không h?p l?
                request.setAttribute("error", "?o?n review không ???c ch?a các ký t? không h?p l?.");
            }
            
            // Hi?n th? l?i trang chi ti?t s?n ph?m
            response.sendRedirect("notaddshopDetail?id=" + Integer.parseInt(aMotorIdStr) + "");
            
        } else {
            // Chuy?n h??ng ??ntrang ??ng nh?p n?u ng??i dùng ch?a ??ng nh?p
            response.sendRedirect("login?id1=10&id2=" + Integer.parseInt(aMotorIdStr) + "");
        }
        
        // Thi?t l?ptiêu ?? Content-Security-Policy (CSP) ?? ng?n ch?n các t?n công XSS khác
        response.setHeader("Content-Security-Policy", "script-src 'self' 'unsafe-inline'; object-src 'none'; base-uri 'self';");
    }
}