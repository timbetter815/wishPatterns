package project.state;

public class PayedState extends OrderState {

	private Order order;
	
	PayedState(Order order) {
		this.order = order;
	}
	
	public void cancelOrder() {
		System.out.println("[SUCCESS] cancell the order, and turn to cancelledState!!!");
		System.out.println("[SUCCESS] return money to you account!!!");
		order.setCurrentOrderstate(Order.cancelledState);
	}

	public void sendGoods() {
		System.out.println("[SUCCESS] send goods for the order, and turn to sentState!!!");
		order.setCurrentOrderstate(Order.sentState);
	}
}
