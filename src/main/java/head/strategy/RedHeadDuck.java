package head.strategy;

public class RedHeadDuck extends Duck {
	
	public RedHeadDuck(){
		flyBehavior = new FlyWithWings();
	}
	
	public void fly() {
		flyBehavior.fly();
	}

}
