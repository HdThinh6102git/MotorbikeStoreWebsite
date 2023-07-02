package com.MotorbikeStore.service.impl;

import javax.inject.Inject;

import com.MotorbikeStore.dao.Ia_MotorcycleDAO;
import com.MotorbikeStore.model.a_MotorcycleModel;
import com.MotorbikeStore.service.IaMotorcycleService;

public class AMotorcycleService implements IaMotorcycleService {
	@Inject
	private Ia_MotorcycleDAO aMotorcycle;
	@Override
	public a_MotorcycleModel save(a_MotorcycleModel newAMotorcycle) {
		
		int aMotorId = aMotorcycle.save(newAMotorcycle);
		return aMotorcycle.findOne(aMotorId);
	}

	@Override
	public a_MotorcycleModel update(a_MotorcycleModel updateAMotorcycle) {
		aMotorcycle.update(updateAMotorcycle);
		
		return aMotorcycle.findOne(updateAMotorcycle.getaMotorId());
	}

	@Override
	public a_MotorcycleModel findOne(int aMotorId) {
		
		return aMotorcycle.findOne(aMotorId);
	}

	@Override
	public void delete(int aMotorId) {
		
			aMotorcycle.delete(aMotorId);
		
		
	}

}
