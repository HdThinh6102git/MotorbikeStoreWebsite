package com.MotorbikeStore.model;

public class CartModel extends AbstractModel<CartModel> {
	private int cartId; 
	private int aMotorId;
	private int userId;
	private int quantity;
	private float totalPrice;
	
	
	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getaMotorId() {
		return aMotorId;
	}

	public void setaMotorId(int aMotorId) {
		this.aMotorId = aMotorId;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	
}
