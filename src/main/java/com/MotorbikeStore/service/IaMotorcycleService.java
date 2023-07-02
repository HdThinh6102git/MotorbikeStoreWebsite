package com.MotorbikeStore.service;

import com.MotorbikeStore.model.a_MotorcycleModel;

public interface IaMotorcycleService {
	a_MotorcycleModel findOne(int aMotorId);
	a_MotorcycleModel save(a_MotorcycleModel newAMotorcycle);
	
	a_MotorcycleModel update(a_MotorcycleModel updateAMotorcycle);
	void delete(int aMotorId);
}
