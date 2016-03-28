package my.abstractFactory;

public class TropicalGardenerFactory implements GardenerFactory{

	public Fruit createFruit(){
		return new TropicalFruit();
	}
	
	public Veggie createVeggie(){
		return new TropicalVeggie();
	}
}
