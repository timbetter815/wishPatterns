package project.state;

public class ReceivedState extends OrderState {
	
	private Order order;
	
	ReceivedState(Order order) {
		this.order = order;
	}

	public void finishOrder() {
		System.out.println("[SUCCESS] coustoms finish the order, and turn to finishedState!!!");
		order.setCurrentOrderstate(Order.finishedState);
	}

}
