package com.MotorbikeStore.model;

public class roleModel {
	private int roleId; 
	private String roleName; 
	private String roleDecs;
	private int[] roleIds;
	public int[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(int[] roleIds) {
		this.roleIds = roleIds;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDecs() {
		return roleDecs;
	}
	public void setRoleDecs(String roleDecs) {
		this.roleDecs = roleDecs;
	}
	
	
	
}
