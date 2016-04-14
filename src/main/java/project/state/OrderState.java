package project.state;

public abstract class OrderState {

	void payOrder(){
		System.out.println("[WARN] You can't payOrder with current state!!!");
	};
	
	void cancelOrder(){
		System.out.println("[WARN] You can't cancelOrder with current state!!!");

	};
	
	void finishOrder(){
		System.out.println("[WARN] You can't finishOrder with current state!!!");
	};
	
	void sendGoods(){
		System.out.println("[WARN] You can't sendGoods with current state!!!");
	};
	
	void receiveGoods(){
		System.out.println("[WARN] You can't receiveGoods with current state!!!");
	};
}
