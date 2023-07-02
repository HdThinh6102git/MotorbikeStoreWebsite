package com.MotorbikeStore.service.impl;

import javax.inject.Inject;

import com.MotorbikeStore.dao.ISpecificationDAO;
import com.MotorbikeStore.model.specificationModel;
import com.MotorbikeStore.service.ISpecificationService;

public class SpecificationService implements ISpecificationService {
	@Inject
	private ISpecificationDAO specification;
	@Override
	public specificationModel save(specificationModel newSpecification) {
		int motorsId = specification.save(newSpecification);
		
		return specification.findOne(motorsId);
	}

	@Override
	public specificationModel update(specificationModel updateSpecification) {
		specification.update(updateSpecification);
		return specification.findOne(updateSpecification.getMotorsId());
	}

	@Override
	public specificationModel findOne(int motorsId) {
		
		return specification.findOne(motorsId);
	}

	@Override
	public void delete(int motorsId) {
		
			specification.delete(motorsId);
		
		
	}

}
