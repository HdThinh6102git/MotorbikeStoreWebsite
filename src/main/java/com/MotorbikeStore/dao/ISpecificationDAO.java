package com.MotorbikeStore.dao;

import com.MotorbikeStore.model.specificationModel;

public interface ISpecificationDAO extends GenericDAO<specificationModel> {
	
	int save (specificationModel newSpecification);
	void update(specificationModel newSpecification);
	void delete(int motorsID);
	specificationModel findOne(int motorsId);
	
}
