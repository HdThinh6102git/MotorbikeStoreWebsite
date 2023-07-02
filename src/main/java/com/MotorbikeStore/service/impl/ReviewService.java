package com.MotorbikeStore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.MotorbikeStore.dao.IReviewDAO;
import com.MotorbikeStore.model.reviewModel;
import com.MotorbikeStore.service.IReviewService;

public class ReviewService implements IReviewService{
	@Inject
	private IReviewDAO reviewDAO;
	@Override
	public int save(reviewModel review) {
		
		return reviewDAO.save(review);
	}

	@Override
	public List<reviewModel> findByaMotorId(int aMotorId) {
		
		return reviewDAO.findByaMotorId(aMotorId);
	}

}
