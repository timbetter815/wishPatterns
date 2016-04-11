package my.decorator;

public class SalesDecoder4Goods implements IGoods {

	private IGoods good;
	// 商品默认八折
	private int off = 8;
	
	// 获取当前打折折扣率
	private int getOff(){
		return this.off;
	}

	public SalesDecoder4Goods(IGoods good){
		this.good = good;
	}

	public int getId() {
		return good.getId();
	}

	public String getName() {
		return good.getName();
	}

	public void setPrice(int price) {
		good.setPrice(price);
	}
	
	// 装饰后的商品价格为打折后价格
	public int getPrice() {
		return good.getPrice() * this.getOff() / 10;
	}
}
