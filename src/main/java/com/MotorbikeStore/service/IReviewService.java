package com.MotorbikeStore.service;

import java.util.List;

import com.MotorbikeStore.model.reviewModel;

public interface IReviewService {
	int save(reviewModel review);
	List<reviewModel> findByaMotorId(int aMotorId);
}
