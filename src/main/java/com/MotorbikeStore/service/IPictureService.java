package com.MotorbikeStore.service;

import java.util.List;

import com.MotorbikeStore.model.PictureModel;

public interface IPictureService {
	int save(PictureModel newPicture);
	void del(int picId);
	PictureModel findOne(int picId);
	PictureModel findOneByAmotorId(int aMotorId);
	List<PictureModel> findAll();
	List<PictureModel> findByAMotorId(int aMotorId);
	List<PictureModel> findNumberPicByAMotorId(int aMotorId, int numberOfPic);
}
