package com.MotorbikeStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MotorbikeStore.model.ProductDetailModel;

public class ProductDetailMapper implements RowMapper<ProductDetailModel> {

	@Override
	public ProductDetailModel mapRow(ResultSet resultSet) {
		try {
			ProductDetailModel productDetail = new ProductDetailModel();
			productDetail.setaMotorId(resultSet.getInt("a_motor_id"));
			productDetail.setMotorsId(resultSet.getInt("motors_id"));
			productDetail.setMotors_Name(resultSet.getString("motors_name"));
			productDetail.setVersion(resultSet.getString("version"));
			productDetail.setMotorType(resultSet.getString("motor_type"));
			productDetail.setBranch(resultSet.getString("branch"));
			
			productDetail.setStyle(resultSet.getString("style"));
			productDetail.setColor(resultSet.getString("color"));
			productDetail.setPrice(resultSet.getFloat("price"));
			
			productDetail.setDate_insert(resultSet.getTimestamp("date_insert"));
			productDetail.setCheckSold(resultSet.getString("check_sold"));
			productDetail.setMotorsDecs(resultSet.getString("motor_desc"));
			productDetail.setCC(resultSet.getFloat("engine_torque"));
			productDetail.setaMotorDesc(resultSet.getString("aMotorDesc"));
			
			
			
			
			return productDetail;
		} catch (SQLException e) {
			return null;
		}
		
		
	}

}
