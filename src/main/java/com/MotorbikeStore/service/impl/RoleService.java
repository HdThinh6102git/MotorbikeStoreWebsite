package com.MotorbikeStore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.MotorbikeStore.dao.IRoleDAO;
import com.MotorbikeStore.model.roleModel;
import com.MotorbikeStore.service.IRoleService;

public class RoleService implements IRoleService {
	
	
	@Inject
	private IRoleDAO roleDAO;
	
	@Override
	public List<roleModel> findAll() {
		
		return roleDAO.findAll();
	}

	
	public List<roleModel> findByRoleID(int roleID) {
		
		return roleDAO.findByRoleID(roleID);
	}



	public roleModel save(roleModel newRoleModel) {
		int roleID = roleDAO.save(newRoleModel);
		
		return roleDAO.findOne(roleID);
	}


	
	public roleModel update(roleModel updateRoleModel) {
		
		roleDAO.update(updateRoleModel);
		
		return roleDAO.findOne(updateRoleModel.getRoleId());
	}


	@Override
	public void delete(int[] roleIds) {
		for(int roleId : roleIds ) {
			roleDAO.delete(roleId);
		}
		
	}
	
}
