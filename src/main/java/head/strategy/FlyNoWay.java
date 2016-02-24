package head.strategy;

public class FlyNoWay implements FlyBehavior{

	public void fly() {
		System.out.println("I can't fly, Because i have not wings...");
	}

}
