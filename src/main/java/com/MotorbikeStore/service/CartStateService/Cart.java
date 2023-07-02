package com.MotorbikeStore.service.CartStateService;

public class Cart {
	private  State state;
	
	public Cart(String stateStr) {
		if(stateStr == "InActiveState") {
			this.state = new InActiveState(this);
		}else if(stateStr == "CheckoutState") {
			this.state = new CheckoutState(this);
		}else {
			this.state = new ActiveState(this);
		}
		
	}
	
	
	
	public State getState() {
		return state;
	}

	public  void setState(State state ) {
		
		this.state = state;
	}
	
}
