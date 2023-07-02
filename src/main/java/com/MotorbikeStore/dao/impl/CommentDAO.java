package com.MotorbikeStore.dao.impl;

import java.util.List;

import com.MotorbikeStore.dao.ICommentDAO;
import com.MotorbikeStore.mapper.commentMapper;
import com.MotorbikeStore.model.commentModel;

public class CommentDAO extends AbstractDAO<commentModel> implements ICommentDAO {

	@Override
	public int save(commentModel comment) {
		String sql ="insert into comment (a_motor_id, user_id, cmt_desc) value(?,?,?);";
		return insert(sql, comment.getaMotorId(), comment.getUserId(), comment.getCmtDecs());
	}

	@Override
	public List<commentModel> findByaMotorId(int aMotorId) {
		String sql = "select user_name,date_cmt, cmt_desc from comment as m, user as u where a_motor_id = ? and m.user_id = u.user_id;";
		
		return query(sql, new commentMapper(), aMotorId);
	}

	@Override
	public void delete(int cmtId) {
		String sql = "delete from comment where cmt_id =?;";
		update(sql, cmtId);
		
	}

}
