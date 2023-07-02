package com.MotorbikeStore.service;

import java.util.List;

import com.MotorbikeStore.model.ProductDetailModel;

public interface IProductDetailService {
	List<ProductDetailModel> findAll();
	List<ProductDetailModel> findByMotorcyclesID(int moID);
	List<ProductDetailModel> findNumberOfMotor(int numberMotor);
	ProductDetailModel findOneByAmotorId(int aMotorId);
	List<ProductDetailModel> searchByName(String txtSearch);
	List<ProductDetailModel> filterPriceAround(int fromNum, int toNum);
	List<ProductDetailModel> filterColor(String color);
	List<ProductDetailModel> filterCC(int fromNum, int toNum);
	List<ProductDetailModel> filterBranch(String branch);
	List<ProductDetailModel> findNumberOfMotorFeature(int numberMotor, String feature);
	List<ProductDetailModel> filterMix(int firstPrice, int seconPrice, String color, int firstCC, int seconCC, String branch, int numberMotor);
}
