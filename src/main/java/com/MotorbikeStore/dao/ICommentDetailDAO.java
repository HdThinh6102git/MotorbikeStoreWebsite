package com.MotorbikeStore.dao;

import java.util.List;

import com.MotorbikeStore.model.commentDetailModel;

public interface ICommentDetailDAO extends GenericDAO<commentDetailModel> {
	List<commentDetailModel> findAll();
}
