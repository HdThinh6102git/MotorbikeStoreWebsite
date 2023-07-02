package com.MotorbikeStore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.MotorbikeStore.dao.ICommentDAO;
import com.MotorbikeStore.model.commentModel;
import com.MotorbikeStore.service.ICommentService;

public class CommentService implements ICommentService{
	@Inject
	private ICommentDAO commentDAO;
	@Override
	public int save(commentModel comment) {
		
		return commentDAO.save(comment);
	}
	@Override
	public List<commentModel> findByaMotorId(int aMotorId) {
		
		return commentDAO.findByaMotorId(aMotorId);
	}
	@Override
	public void delete(int cmtId) {
		commentDAO.delete(cmtId);
		
	}

}
