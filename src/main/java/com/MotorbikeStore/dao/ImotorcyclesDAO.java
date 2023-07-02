package com.MotorbikeStore.dao;

import java.util.List;

import com.MotorbikeStore.model.motorcyclesModel;

public interface ImotorcyclesDAO extends GenericDAO<motorcyclesModel>{
	List<motorcyclesModel> findName();
	
	motorcyclesModel findOne(int motorsId);
	int save(motorcyclesModel newmotorcycle);
	void delete(int motorsID);
	void update(motorcyclesModel updatemotorcycle);
}
