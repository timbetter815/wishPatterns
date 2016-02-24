package head.strategy;

public abstract class Duck {
	FlyBehavior flyBehavior;
	void fly(){
		flyBehavior.fly();
	};

}
