package com.MotorbikeStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MotorbikeStore.model.commentDetailModel;

public class commentDetailMapper implements RowMapper<commentDetailModel>{

	@Override
	public commentDetailModel mapRow(ResultSet resultSet) {
		
		try {
			commentDetailModel commentDetail = new commentDetailModel();
			commentDetail.setCmtId(resultSet.getInt("cmt_id"));
			commentDetail.setUserName(resultSet.getString("user_name"));
			commentDetail.setCmtDesc(resultSet.getString("cmt_desc"));
			commentDetail.setDateCmt(resultSet.getTimestamp("date_cmt"));
			commentDetail.setaMotorId(resultSet.getInt("a_motor_id"));
			commentDetail.setMotorName(resultSet.getString("motors_name"));
			commentDetail.setMotorColor(resultSet.getString("color"));
			
			return commentDetail;
		} catch (SQLException e) {
			return null;
		}
	}

}
