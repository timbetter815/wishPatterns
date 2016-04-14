package project.state;

public class CancelledState extends OrderState {
	
	private Order order;
	
	CancelledState(Order order) {
		this.order = order;
	}

	public void finishOrder() {
		System.out.println("[SUCCESS] coustoms has finish the cancelled order, and turn to finishedState!!!");
		order.setCurrentOrderstate(Order.finishedState);
	}


}
