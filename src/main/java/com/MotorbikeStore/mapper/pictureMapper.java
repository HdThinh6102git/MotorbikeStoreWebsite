package com.MotorbikeStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MotorbikeStore.model.PictureModel;

public class pictureMapper implements RowMapper<PictureModel>{

	@Override
	public PictureModel mapRow(ResultSet resultSet) {
		try {
			PictureModel picture = new PictureModel();
			picture.setaMotorId(resultSet.getInt("a_motor_id"));
			picture.setPicId(resultSet.getInt("pic_id"));
			picture.setPicName(resultSet.getString("picName"));	
			return picture;
		} catch (SQLException e) {
			return null;
		}
	}

}
