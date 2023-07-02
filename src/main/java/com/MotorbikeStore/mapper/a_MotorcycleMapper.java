package com.MotorbikeStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MotorbikeStore.model.a_MotorcycleModel;

public class a_MotorcycleMapper implements RowMapper<a_MotorcycleModel>{

	@Override
	public a_MotorcycleModel mapRow(ResultSet resultSet) {
		
		try {
			a_MotorcycleModel aMotorcycle = new a_MotorcycleModel();
			aMotorcycle.setaMotorId(resultSet.getInt("a_motor_id"));
			aMotorcycle.setMotorsId(resultSet.getInt("motors_id"));
			aMotorcycle.setColor(resultSet.getString("color"));
			aMotorcycle.setPrice(resultSet.getFloat("price"));
			aMotorcycle.setDateInsert(resultSet.getTimestamp("date_insert"));
			if (resultSet.getTimestamp("date_update") != null) {
				aMotorcycle.setDateUpdate(resultSet.getTimestamp("date_update"));
			}
			aMotorcycle.setCheckSold(resultSet.getString("check_sold"));
			aMotorcycle.setaMotorDesc(resultSet.getString("aMotorDesc"));
			
			return aMotorcycle;
		} catch (SQLException e) {
			return null;
		}
	}

}
