package head.observer;

public class CurrentDataDisplay implements Observer {

	// 每次主题subject 发布通知时候，则会调用各个观察者的update
	public void update() {
		display();
	}

	public void display() {
		System.out.println("The current weather is ...");
	}

}
