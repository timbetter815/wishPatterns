package project.state;

public class NewState extends OrderState {
	
	private Order order;
	
	NewState(Order order) {
		this.order = order;
	}

	public void payOrder() {
		System.out.println("[SUCCESS]pay for a new order, and turn to payedState!!!");
		order.setCurrentOrderstate(Order.payedState);
	}

	public void cancelOrder() {
		System.out.println("[SUCCESS]cancell the order, and turn to cancelledState!!!");
		order.setCurrentOrderstate(Order.cancelledState);
	}
	
	public void sendGoods() {
		System.out.println("[WARN] can't send the goods, pleace pay for the order before send goods!!!");
	}
}
