package head.decorator;

public class HouseBlend extends Beverage {

	public HouseBlend(){
		super.discription = "HouseBlend";
	}
	
	@Override
	public Double getCost() {
		return 0.88;
	}

}
