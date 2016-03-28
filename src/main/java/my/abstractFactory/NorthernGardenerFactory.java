package my.abstractFactory;

public class NorthernGardenerFactory implements GardenerFactory{

	public Fruit createFruit(){
		return new NorthernFruit();
	}
	
	public Veggie createVeggie(){
		return new NorthernVeggie();
	}
}
