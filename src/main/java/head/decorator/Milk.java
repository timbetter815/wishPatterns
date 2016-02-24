package head.decorator;

public class Milk extends CondimentDecorator {
	Beverage beverage;
	
	public Milk(Beverage beverage){
		this.beverage = beverage;
	}
	@Override
	public Double getCost() {
		return this.beverage.getCost() + 0.1;
	}
	
	String getDiscription(){
		return this.beverage.getDiscription() + "+Milk";
	}

}
