package com.MotorbikeStore.dao;

import java.util.List;

import com.MotorbikeStore.model.reviewModel;

public interface IReviewDAO extends GenericDAO<reviewModel> {
	int save(reviewModel review);
	List<reviewModel> findByaMotorId(int aMotorId);
}
