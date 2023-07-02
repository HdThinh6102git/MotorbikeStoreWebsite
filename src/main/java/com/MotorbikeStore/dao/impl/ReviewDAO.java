package com.MotorbikeStore.dao.impl;

import java.util.List;

import com.MotorbikeStore.dao.IReviewDAO;
import com.MotorbikeStore.mapper.reviewMapper;
import com.MotorbikeStore.model.reviewModel;

public class ReviewDAO extends AbstractDAO<reviewModel> implements IReviewDAO {

	@Override
	public int save(reviewModel review) {
		String sql = "insert into review (a_motor_id, user_id, rv_desc) value(?,?,?);";
		return insert(sql, review.getaMotorId(), review.getUserId(), review.getRvDesc());

	}

	@Override
	public List<reviewModel> findByaMotorId(int aMotorId) {
		String sql = "select user_name,date_rv, rv_desc from review as r, user as u where a_motor_id = ? and r.user_id = u.user_id;";

		return query(sql, new reviewMapper(), aMotorId);
	}

}
