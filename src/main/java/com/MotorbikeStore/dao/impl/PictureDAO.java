package com.MotorbikeStore.dao.impl;

import java.util.List;

import com.MotorbikeStore.dao.IPictureDAO;
import com.MotorbikeStore.mapper.pictureMapper;
import com.MotorbikeStore.model.PictureModel;

public class PictureDAO extends AbstractDAO<PictureModel> implements IPictureDAO {

	@Override
	public int save(PictureModel newPicture) {
		String sql = "insert into picturepro (picName, a_motor_id) value(?,?); ";

		return insert(sql, newPicture.getPicName(), newPicture.getaMotorId());
	}

	@Override
	public void del(int picId) {
		String sql = "delete from picturepro where pic_id =?;";

		update(sql, picId);
	}

	@Override
	public PictureModel findOne(int picId) {
		String sql = "select * from picturepro  where pic_id =?";

		List<PictureModel> Picture = query(sql, new pictureMapper(), picId);

		return Picture.isEmpty() ? null : Picture.get(0);
	}

	@Override
	public List<PictureModel> findAll() {
		String sql = "select * from picturepro  ";
		return query(sql, new pictureMapper());
	}

	@Override
	public List<PictureModel> findByAMotorId(int aMotorId) {
		String sql = "select * from picturepro  where a_motor_id =?";

		

		return query(sql, new pictureMapper(), aMotorId);
	}

	@Override
	public List<PictureModel> findNumberPicByAMotorId(int aMotorId, int numberOfPic) {
		String sql = "select * from picturepro  where a_motor_id =? LIMIT ?";
		return query(sql, new pictureMapper(), aMotorId, numberOfPic);
	}

	@Override
	public PictureModel findOneByAmotorId(int aMotorId) {
		String sql = "select * from picturepro  where a_motor_id =? LIMIT 1";
		 List<PictureModel> Picture = query(sql, new pictureMapper(), aMotorId);
		 return Picture.isEmpty() ? null : Picture.get(0);
	}

}
