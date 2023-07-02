package com.MotorbikeStore.dao;

import com.MotorbikeStore.model.a_MotorcycleModel;

public interface Ia_MotorcycleDAO extends GenericDAO<a_MotorcycleModel> {
	a_MotorcycleModel findOne(int aMotorId);
	int save(a_MotorcycleModel newAMotorcycle);
	void delete(int aMotorId);
	void update(a_MotorcycleModel updateAMotorcycle);
	
}
