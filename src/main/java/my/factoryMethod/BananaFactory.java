package my.factoryMethod;

public class BananaFactory implements FruitFactory{

	public Fruit factory() {
		return new Banana();
	}

}
