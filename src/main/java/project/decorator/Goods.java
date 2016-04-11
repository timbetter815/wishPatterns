package project.decorator;

public class Goods implements IGoods {

	private int id;
	private String name;
	private int price;
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
