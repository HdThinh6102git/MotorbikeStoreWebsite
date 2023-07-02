package com.MotorbikeStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MotorbikeStore.model.motorcyclesModel;

public class motorcyclesMapper implements RowMapper<motorcyclesModel> {

	@Override
	public motorcyclesModel mapRow(ResultSet resultSet) {
		
		try {
			motorcyclesModel motorcycles = new motorcyclesModel();
			motorcycles.setMotorsId(resultSet.getInt("motors_id"));
			motorcycles.setMotors_Name(resultSet.getString("motors_name"));
			motorcycles.setVersion(resultSet.getString("version"));
			motorcycles.setMotorType(resultSet.getString("motor_type"));
			motorcycles.setBranch(resultSet.getString("branch"));
			motorcycles.setStyle(resultSet.getString("style"));
			motorcycles.setQuantity(resultSet.getInt("quantity"));
			motorcycles.setCheckSale(resultSet.getString("check_sale"));
			motorcycles.setMotors_decs(resultSet.getString("motor_desc"));
			
			
			
			
			
			return motorcycles;
		} catch (SQLException e) {
			return null;
		}
	}

}
