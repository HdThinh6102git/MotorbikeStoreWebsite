package com.MotorbikeStore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.MotorbikeStore.dao.ICommentDetailDAO;
import com.MotorbikeStore.model.commentDetailModel;
import com.MotorbikeStore.service.ICommentDetailService;

public class CommentDetailService implements ICommentDetailService {
	@Inject
	private ICommentDetailDAO CommentDetailDAO;
	@Override
	public List<commentDetailModel> findAll() {
		
		return CommentDetailDAO.findAll();
	}

}
