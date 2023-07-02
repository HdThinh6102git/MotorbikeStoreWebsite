package com.MotorbikeStore.dao.impl;

import java.util.List;

import com.MotorbikeStore.dao.ISpecificationDAO;
import com.MotorbikeStore.mapper.specificationMapper;
import com.MotorbikeStore.model.specificationModel;

public class specificationDAO extends AbstractDAO<specificationModel> implements ISpecificationDAO {

	@Override
	public int save(specificationModel newSpecification) {
		StringBuilder sql = new StringBuilder("INSERT INTO specification (motors_id, size,mass_kg,saddle_height_cm,  rpm, engine_torque, horse_power) ");
		sql.append("values( ?,?,?,?,?,?,?);");
		return insert(sql.toString(),newSpecification.getMotorsId(), newSpecification.getSize(), newSpecification.getMassKg(), newSpecification.getSaddleHeightCm(),
				newSpecification.getRpm(), newSpecification.getEngineTorque(), newSpecification.getHorsePower());
	}

	@Override
	public void update(specificationModel updateSpecification) {
		StringBuilder sql = new StringBuilder("update specification ");
		sql.append("set size =?, mass_kg=?, saddle_height_cm=?,");
		sql.append("rpm=?,engine_torque=?,horse_power=?");
		sql.append("where motors_id =?;");
		update(sql.toString(),updateSpecification.getSize(), updateSpecification.getMassKg(), 
				updateSpecification.getSaddleHeightCm(), updateSpecification.getRpm(),
				updateSpecification.getEngineTorque(), updateSpecification.getHorsePower(),
				updateSpecification.getMotorsId());
		
	}

	@Override
	public specificationModel findOne(int motorsId) {
		
		String sql = "select * from specification where motors_id = ?";
		List<specificationModel> specification = query(sql,new specificationMapper(), motorsId);
		return specification.isEmpty() ? null : specification.get(0);
	}

	@Override
	public void delete(int motorsID) {

		String sql = "delete from specification where motors_id = ?";
		update(sql, motorsID);
		
	}

}
