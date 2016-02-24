package head.strategy;

public class ToyDuck extends Duck {
	
	public ToyDuck(){
		flyBehavior = new FlyNoWay();
	}
	
	public void fly() {
		flyBehavior.fly();
	}

}
