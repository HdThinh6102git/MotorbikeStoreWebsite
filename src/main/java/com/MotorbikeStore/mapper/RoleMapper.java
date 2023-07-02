package com.MotorbikeStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MotorbikeStore.model.roleModel;

public class RoleMapper implements RowMapper<roleModel>{

	@Override
	public roleModel mapRow(ResultSet resultSet) {
		
		try {
			roleModel role = new roleModel();
			role.setRoleId(resultSet.getInt("role_id"));
			role.setRoleName(resultSet.getString("role_name"));
			role.setRoleDecs(resultSet.getString("role_decs"));
			return role;
		} catch (SQLException e) {
			return null;
		}
		
		
	}
	
}
