package com.MotorbikeStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MotorbikeStore.model.reviewModel;

public class reviewMapper implements RowMapper<reviewModel>{

	@Override
	public reviewModel mapRow(ResultSet resultSet) {
		try {
			reviewModel review = new reviewModel();
			review.setRvDesc(resultSet.getString("rv_desc"));
			
			review.setDaterv(resultSet.getTimestamp("date_rv"));
			
			review.setUserName(resultSet.getString("user_name"));
			
			
			return review;
		} catch (SQLException e) {
			return null;
		}
	}

}
