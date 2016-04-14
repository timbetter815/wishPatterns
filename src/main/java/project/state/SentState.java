package project.state;

public class SentState extends OrderState {

	private Order order;
	
	SentState(Order order) {
		this.order = order;
	}
	
	public void cancelOrder() {
		System.out.println("[WARN] You can't cancell the order， because the goods has sent, you can receiver the goods and connect the Customer Service!!!");
	}


	public void receiveGoods() {
		System.out.println("[SUCCESS] coustoms has receive the goods, and turn to receivedState!!!");
		order.setCurrentOrderstate(Order.receivedState);
	}

}
