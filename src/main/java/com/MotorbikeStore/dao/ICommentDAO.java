package com.MotorbikeStore.dao;

import java.util.List;

import com.MotorbikeStore.model.commentModel;

public interface ICommentDAO extends GenericDAO<commentModel>{
	int save(commentModel comment);
	void delete(int cmtId);
	List<commentModel> findByaMotorId(int aMotorId);
}
