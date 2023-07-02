package com.MotorbikeStore.service;

import com.MotorbikeStore.model.specificationModel;

public interface ISpecificationService {
	specificationModel save (specificationModel newSpecification);
	specificationModel update(specificationModel newSpecification);
	specificationModel findOne(int motorsId);
	void delete(int motorsId);
}
