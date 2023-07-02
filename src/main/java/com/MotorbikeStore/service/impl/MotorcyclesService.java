package com.MotorbikeStore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.MotorbikeStore.dao.ImotorcyclesDAO;
import com.MotorbikeStore.model.motorcyclesModel;
import com.MotorbikeStore.service.IMotorcyclesService;

public class MotorcyclesService implements IMotorcyclesService{
	@Inject
	private ImotorcyclesDAO motorcycles;
	@Override
	public List<motorcyclesModel> findName() {
		
		return motorcycles.findName();
	}
	@Override
	public motorcyclesModel save(motorcyclesModel newMotorcycle) {
		int motorsID = motorcycles.save(newMotorcycle);
		
		return motorcycles.findOne(motorsID);
	}
	@Override
	public motorcyclesModel update(motorcyclesModel updateMotorcycle) {
		motorcycles.update(updateMotorcycle);
		return motorcycles.findOne(updateMotorcycle.getMotorsId());
	}
	@Override
	public void delete(int motorsId) {
		
		
			motorcycles.delete(motorsId);
		
	}
	@Override
	public motorcyclesModel findOneById(int motorsId) {
		
		return motorcycles.findOne(motorsId);
	}

}
