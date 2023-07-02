package com.MotorbikeStore.dao;

import java.util.List;

import com.MotorbikeStore.model.roleModel;

public interface IRoleDAO extends GenericDAO<roleModel> {
	 roleModel findOne(int id);
	 List<roleModel> findAll();
	 List<roleModel> findByRoleID(int roleID);
	 int save(roleModel newRoleModel);
	 void update(roleModel updateRoleModel);
	 void delete(int roleId);
}
