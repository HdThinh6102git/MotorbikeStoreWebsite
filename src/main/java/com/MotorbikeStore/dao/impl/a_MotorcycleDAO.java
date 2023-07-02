package com.MotorbikeStore.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import com.MotorbikeStore.dao.Ia_MotorcycleDAO;
import com.MotorbikeStore.mapper.a_MotorcycleMapper;
import com.MotorbikeStore.model.a_MotorcycleModel;

public class a_MotorcycleDAO extends AbstractDAO<a_MotorcycleModel> implements Ia_MotorcycleDAO {

	@Override
	public int save(a_MotorcycleModel newAMotorcycle) {
		StringBuilder sql = new StringBuilder("INSERT INTO a_motorcycle (a_motor_id,motors_id,color,check_sold, price,date_update, aMotorDesc) ");
		sql.append("values(?,?,?,?, ?,?,?);");
		newAMotorcycle.setDateUpdate(new Timestamp(System.currentTimeMillis()));
		return insert(sql.toString(), newAMotorcycle.getaMotorId(), newAMotorcycle.getMotorsId(), newAMotorcycle.getColor(),
				newAMotorcycle.getCheckSold(), newAMotorcycle.getPrice(), newAMotorcycle.getDateUpdate(), newAMotorcycle.getaMotorDesc());
	
	}

	@Override
	public void update(a_MotorcycleModel updateAMotorcycle) {
		StringBuilder sql = new StringBuilder("update a_motorcycle ");
		sql.append("set motors_id =?, color=?,price=?,");
		sql.append("date_update=?,check_sold=?, aMotorDesc = ?");
		sql.append("where a_motor_id=?;");
		updateAMotorcycle.setDateUpdate(new Timestamp(System.currentTimeMillis()));
		update(sql.toString(), updateAMotorcycle.getMotorsId(), updateAMotorcycle.getColor(),
				updateAMotorcycle.getPrice(), updateAMotorcycle.getDateUpdate(), updateAMotorcycle.getCheckSold(),
				updateAMotorcycle.getaMotorDesc(),updateAMotorcycle.getaMotorId());
		
	}

	@Override
	public void delete(int aMotorId) {
		String sql = "Delete from a_motorcycle where a_motor_id=?";
		update(sql, aMotorId);
		
	}

	@Override
	public a_MotorcycleModel findOne(int aMotorId) {
		String sql = "select * from a_motorcycle  where a_motor_id =?";
		List<a_MotorcycleModel> aMotor = query(sql, new a_MotorcycleMapper(), aMotorId);
		
		return aMotor.isEmpty() ? null : aMotor.get(0);
	}

	
	

}
