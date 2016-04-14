package project.state;

public class FinishedState extends OrderState {
	
	private Order order;
	
	FinishedState(Order order) {
		this.order = order;
	}
}
