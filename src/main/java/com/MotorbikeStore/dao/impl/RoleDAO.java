package com.MotorbikeStore.dao.impl;

import java.util.List;

import com.MotorbikeStore.dao.IRoleDAO;
import com.MotorbikeStore.mapper.RoleMapper;
import com.MotorbikeStore.model.roleModel;

public class RoleDAO extends AbstractDAO<roleModel> implements IRoleDAO{

	@Override
	public List<roleModel> findAll() {
		
		String sql = "select * from role ";
		return query(sql, new RoleMapper() );
		
	}

	
	public List<roleModel> findByRoleID(int roleID) {
		String sql = "select * from role where role_id =?";
		return query(sql, new RoleMapper(), roleID);
	}



	public int save(roleModel newRoleModel) {
		String sql ="insert into role (role_name,role_decs) values( ?,?)";
		return insert(sql,newRoleModel.getRoleName(), newRoleModel.getRoleDecs() );
		
		
	}


	
	public roleModel findOne(int roleID) {
		String sql = "select * from role where role_id =?";
		List<roleModel> role =  query(sql, new RoleMapper(), roleID);
		
		return role.isEmpty() ? null : role.get(0);
	}


	@Override
	public void update(roleModel updateRoleModel) {
		StringBuilder sql = new StringBuilder("update role ");
		sql.append("set  role_name = ?, role_decs = ? ");
		sql.append("where role_id = ?");
		update(sql.toString(),updateRoleModel.getRoleName(), updateRoleModel.getRoleDecs(), updateRoleModel.getRoleId() );
		
	}


	@Override
	public void delete(int roleId) {
		
		String sql = "Delete from role where role_id = ?";
		update(sql, roleId);
	}

	
	

}
