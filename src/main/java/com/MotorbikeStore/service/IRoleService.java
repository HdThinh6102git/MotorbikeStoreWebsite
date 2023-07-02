package com.MotorbikeStore.service;

import java.util.List;

import com.MotorbikeStore.model.roleModel;

public interface IRoleService {
	List<roleModel> findAll();
	List<roleModel> findByRoleID(int roleID);
	roleModel save(roleModel newRoleModel);
	roleModel update(roleModel updateRoleModel);
	void delete(int[] roleIds ) ;
}
