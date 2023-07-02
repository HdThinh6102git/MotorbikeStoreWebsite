package com.MotorbikeStore.service;

import java.util.List;

import com.MotorbikeStore.model.motorcyclesModel;

public interface IMotorcyclesService {
	List<motorcyclesModel> findName();
	motorcyclesModel findOneById(int motorsId);
	motorcyclesModel save(motorcyclesModel newMotorcycle);
	motorcyclesModel update(motorcyclesModel updateMotorcycle);
	void delete(int motorsId);
}
