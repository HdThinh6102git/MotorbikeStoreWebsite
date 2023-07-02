package com.MotorbikeStore.dao.impl;

import java.util.List;

import com.MotorbikeStore.dao.ICommentDetailDAO;
import com.MotorbikeStore.mapper.commentDetailMapper;
import com.MotorbikeStore.model.commentDetailModel;

public class CommentDetailDAO extends AbstractDAO<commentDetailModel> implements ICommentDetailDAO {

	@Override
	public List<commentDetailModel> findAll() {
		String sql = "select cmt_id, user_name,cmt_desc, date_cmt , c.a_motor_id, motors_name, color   from motorcycles as m, comment as c, user as u, a_motorcycle as a where c.user_id = u.user_id and c.a_motor_id = a.a_motor_id and m.motors_id = a.motors_id;";
		return query(sql, new commentDetailMapper());
	}
	
}
