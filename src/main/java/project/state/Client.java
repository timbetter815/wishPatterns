package project.state;

public class Client {

	public static void main(String[] args) {
		
		// 正常的购买流程：新建订单->订单付款->发货->收货->完成订单
		Order order = new Order();
		order.payOrder();
		order.sendGoods();
		order.receiveGoods();
		order.finishOrder();
		
		// 购买流程1：新建订单->订单付款->取消订单->完成订单
		order = new Order();
		order.payOrder();
		order.cancelOrder();
		order.finishOrder();
		
		// 购买流程2：新建订单->订单付款->发货->取消订单->完成订单（模拟场景：对于已发货的订单，不能被取消）
		order = new Order();
		order.payOrder();
		order.sendGoods();
		order.cancelOrder();
		order.finishOrder();
		
		// 购买流程3：新建订单->发货（模拟场景：未付款的订单，不能发货）
		order = new Order();
		order.sendGoods();
	}

}
