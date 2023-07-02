package com.MotorbikeStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MotorbikeStore.model.commentModel;

public class commentMapper implements RowMapper<commentModel>{

	@Override
	public commentModel mapRow(ResultSet resultSet) {
		
		try {
			commentModel comment = new commentModel();
			
			comment.setCmtDecs(resultSet.getString("cmt_desc"));
			
			comment.setDatecmt(resultSet.getTimestamp("date_cmt"));
			
			comment.setUserName(resultSet.getString("user_name"));
			return comment;
		} catch (SQLException e) {
			return null;
		}
	}

}
