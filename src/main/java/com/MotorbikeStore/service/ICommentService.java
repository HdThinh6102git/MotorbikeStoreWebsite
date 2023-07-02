package com.MotorbikeStore.service;

import java.util.List;

import com.MotorbikeStore.model.commentModel;

public interface ICommentService {
	int save(commentModel comment);
	void delete(int cmtId);
	List<commentModel> findByaMotorId(int aMotorId);
}
