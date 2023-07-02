package com.MotorbikeStore.dao.impl;

import java.util.List;

import com.MotorbikeStore.dao.ImotorcyclesDAO;
import com.MotorbikeStore.mapper.motorcyclesMapper;
import com.MotorbikeStore.model.motorcyclesModel;

public class motorcyclesDAO extends AbstractDAO<motorcyclesModel> implements ImotorcyclesDAO{

	@Override
	public List<motorcyclesModel> findName() {
		String sql = "select *  from motorcycles;";
		return query(sql, new motorcyclesMapper());
	}

	@Override
	public int save(motorcyclesModel newmotorcycle) {
		String sql ="INSERT INTO motorcycles (motors_id, motors_name,version,motor_type,  branch, style,quantity,check_sale, motor_desc) \r\n"
				+ "values( ?, ?,?,?,  ?, ?,?,?, ?)";
		return insert(sql,newmotorcycle.getMotorsId(), newmotorcycle.getMotors_Name(), newmotorcycle.getVersion(), newmotorcycle.getMotorType()
				,newmotorcycle.getBranch(), newmotorcycle.getStyle(), newmotorcycle.getQuantity(), newmotorcycle.getCheckSale(), 
				newmotorcycle.getMotors_decs());
	}

	@Override
	public void delete(int motorsID) {
		String sql = "delete from motorcycles where motors_id = ?";
		update(sql, motorsID);
	}

	@Override
	public void update(motorcyclesModel updatemotorcycle) {
		
		StringBuilder sql = new StringBuilder("update motorcycles ");
		sql.append("set motors_name =?, version=?, ");
		sql.append("motor_type=?,branch=?,style=?,quantity=?,");
		sql.append("motor_desc=?,check_sale=? ");
		sql.append(" where motors_id =?;");
		update(sql.toString(),updatemotorcycle.getMotors_Name(), updatemotorcycle.getVersion(), updatemotorcycle.getMotorType(),
				updatemotorcycle.getBranch(), updatemotorcycle.getStyle(), updatemotorcycle.getQuantity(), 
				updatemotorcycle.getMotors_decs(),updatemotorcycle.getCheckSale(), updatemotorcycle.getMotorsId());
	}

	@Override
	public motorcyclesModel findOne(int motorsId) {
		String sql = "select * from motorcycles where motors_id = ?";
		List<motorcyclesModel> motorcycles = query(sql,new motorcyclesMapper(), motorsId);
		return motorcycles.isEmpty() ? null : motorcycles.get(0);
	}

	

}
