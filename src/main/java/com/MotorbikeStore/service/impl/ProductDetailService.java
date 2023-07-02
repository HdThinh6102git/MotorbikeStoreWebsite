package com.MotorbikeStore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.MotorbikeStore.dao.IProductDetailDAO;
import com.MotorbikeStore.model.ProductDetailModel;
import com.MotorbikeStore.service.IProductDetailService;

public class ProductDetailService implements IProductDetailService {

	@Inject
	private IProductDetailDAO productDetailDAO;
	@Override
	public List<ProductDetailModel> findAll() {
		
		return productDetailDAO.findAll();
	}
	@Override
	public List<ProductDetailModel> findByMotorcyclesID(int moID) {
		if(moID == 0 ) {
			return productDetailDAO.findAll();
		}
		return productDetailDAO.findByMotorcyclesID(moID);
	}
	@Override
	public List<ProductDetailModel> findNumberOfMotor(int numberMotor) {
		
		return productDetailDAO.findNumberOfMotor(numberMotor);
	}
	@Override
	public ProductDetailModel findOneByAmotorId(int aMotorId) {
		
		return productDetailDAO.findOneByAmotorId(aMotorId);
	}
	@Override
	public List<ProductDetailModel> searchByName(String txtSearch) {
		
		return productDetailDAO.searchByName(txtSearch);
	}
	@Override
	public List<ProductDetailModel> filterPriceAround(int fromNum, int toNum) {
		
		return productDetailDAO.filterPriceAround(fromNum, toNum);
	}
	@Override
	public List<ProductDetailModel> filterColor(String color) {
		
		return productDetailDAO.filterColor(color);
	}
	@Override
	public List<ProductDetailModel> filterCC(int fromNum, int toNum) {
		
		return productDetailDAO.filterCC(fromNum, toNum);
	}
	@Override
	public List<ProductDetailModel> filterBranch(String branch) {
		
		return productDetailDAO.filterBranch(branch);
	}
	@Override
	public List<ProductDetailModel> findNumberOfMotorFeature(int numberMotor, String feature) {
		
		return productDetailDAO.findNumberOfMotorFeature(numberMotor, feature);
	}
	@Override
	public List<ProductDetailModel> filterMix(int firstPrice, int seconPrice, String color, int firstCC, int seconCC,
			String branch, int numberMotor) {
		
		return productDetailDAO.filterMix(firstPrice, seconPrice, color, firstCC, seconCC, branch, numberMotor);
	}

}
