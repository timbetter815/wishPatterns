package project.state;

public class Order {

	static OrderState newState;
	static OrderState payedState;
	static OrderState sentState;
	static OrderState receivedState;
	static OrderState cancelledState;
	static OrderState finishedState;
	
	Order(){
		System.out.println("\n---- 创建订单开始ing............");
		newState = new NewState(this);
		payedState = new PayedState(this);
		sentState = new SentState(this);
		receivedState = new ReceivedState(this);
		cancelledState = new CancelledState(this);
		finishedState = new FinishedState(this);
	}
	
	private OrderState currentOrderstate = new NewState(this);
	
	public OrderState getCurrentOrderstate() {
		return currentOrderstate;
	}

	public void setCurrentOrderstate(OrderState currentOrderstate) {
		this.currentOrderstate = currentOrderstate;
	}

	void payOrder(){
		currentOrderstate.payOrder();
	};
	
	void cancelOrder(){
		currentOrderstate.cancelOrder();
	};
	
	void finishOrder(){
		currentOrderstate.finishOrder();
	};
	
	void sendGoods(){
		currentOrderstate.sendGoods();
	};
	
	void receiveGoods(){
		currentOrderstate.receiveGoods();
	};
}
