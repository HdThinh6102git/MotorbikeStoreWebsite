package com.MotorbikeStore.model;

import java.util.ArrayList;
import java.util.List;

import com.MotorbikeStore.utils.IterableList;

public class AbstractModel<T> {
	private int[] ids;

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}
	private List<T> listResult = new ArrayList<>();
	public IterableList<T> listResult1 = new IterableList<T>();

	public List<T> getListResult() {
		return listResult;
	}
	
	public IterableList<T> getListResult1() {
		return listResult1;
	}

	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
	
	public void setListResult(IterableList<T> listResult) {
		this.listResult1 = listResult;
	}
}
