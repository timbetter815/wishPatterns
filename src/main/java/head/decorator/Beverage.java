package head.decorator;

public abstract class Beverage {
	String discription = "UnKnow Beverage";
	
	String getDiscription(){
		return discription;
	}
	
	public abstract Double getCost();
}
