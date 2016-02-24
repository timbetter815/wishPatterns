package head.decorator;

public class Espresso extends Beverage {

	public Espresso(){
		super.discription = "Espresso";
	}
	
	@Override
	public Double getCost() {
		return 1.99;
	}

}
