package head.decorator;

public class Mocha extends CondimentDecorator {
	Beverage beverage;
	
	public Mocha(Beverage beverage){
		this.beverage = beverage;
	}
	@Override
	public Double getCost() {
		return this.beverage.getCost() + 0.2;
	}
	
	String getDiscription(){
		return this.beverage.getDiscription() + "+Mocha";
	}

}
