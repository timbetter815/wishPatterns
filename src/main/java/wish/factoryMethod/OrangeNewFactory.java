package wish.factoryMethod;

public class OrangeNewFactory implements FruitFactory{

	public Fruit factory() {
		return new OrangeNew();
	}

}
