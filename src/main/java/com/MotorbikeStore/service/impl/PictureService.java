package com.MotorbikeStore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.MotorbikeStore.dao.IPictureDAO;
import com.MotorbikeStore.model.PictureModel;
import com.MotorbikeStore.service.IPictureService;

public class PictureService implements IPictureService {
	@Inject 
	private IPictureDAO PictureDAO;
	@Override
	public int save(PictureModel newPicture) {
		
		return PictureDAO.save(newPicture);
	}

	@Override
	public void del(int picId) {
		PictureDAO.del(picId);
		
	}

	@Override
	public PictureModel findOne(int picId) {
		
		return PictureDAO.findOne(picId);
	}

	@Override
	public List<PictureModel> findAll() {
		
		return PictureDAO.findAll();
	}

	@Override
	public List<PictureModel> findByAMotorId(int aMotorId) {
		
		return PictureDAO.findByAMotorId(aMotorId);
	}

	@Override
	public List<PictureModel> findNumberPicByAMotorId(int aMotorId, int numberOfPic) {
		
		return PictureDAO.findNumberPicByAMotorId(aMotorId, numberOfPic);
	}

	@Override
	public PictureModel findOneByAmotorId(int aMotorId) {
		
		return PictureDAO.findOneByAmotorId(aMotorId);
	}

}
