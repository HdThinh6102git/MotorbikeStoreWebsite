package com.MotorbikeStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MotorbikeStore.model.specificationModel;

public class specificationMapper implements RowMapper<specificationModel>{

	@Override
	public specificationModel mapRow(ResultSet resultSet) {
		
		try {
			specificationModel specification = new specificationModel();
			specification.setMotorsId(resultSet.getInt("motors_id"));
			specification.setSize(resultSet.getString("size"));
			specification.setMassKg(resultSet.getFloat("mass_kg"));
			specification.setSaddleHeightCm(resultSet.getFloat("saddle_height_cm"));
			specification.setRpm(resultSet.getInt("rpm"));
			specification.setEngineTorque(resultSet.getFloat("engine_torque"));
			specification.setHorsePower(resultSet.getString("horse_power"));
			
			
			
			return specification;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
