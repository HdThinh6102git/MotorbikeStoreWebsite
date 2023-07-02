package com.MotorbikeStore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.MotorbikeStore.model.roleModel;
import com.MotorbikeStore.model.userModel;

public class UserMapper implements RowMapper<userModel>
{

	@Override
	public userModel mapRow(ResultSet resultSet) {
		// Check lai chuoi id email username pass
		try {  
			userModel user = new userModel();
			user.setUserId(resultSet.getInt("user_id")); //NOTE
			user.setEmail(resultSet.getString("email"));
			//user.setUserName(resultSet.getString("user_name"));
			user.setUserPass(resultSet.getString("user_pass"));
			user.setRoleId(resultSet.getInt("role_id"));
//			roleModel role = new roleModel();
//			role.setRoleId(resultSet.getInt("role_id"));
//			role.setRoleName(resultSet.getString("role_name"));
			return user;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
