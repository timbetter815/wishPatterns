package project.decorator;

/**
 * DESC 装饰模式是继承关系的一个替代方案。不管装饰多少层，返回的对象还是Component对象
 *   -- 装饰模式可以动态的扩展一个实现类的功能
 *   
 *   -- 还可以同时装饰打折及满减等多个可以重复参加的活动来获取最终支付价格
 * @author ttx
 * @since 2016年4月11日 下午11:22:08
 */
public class Client {
	
	public static void main(String[] args) {
		IGoods goods = new Goods();
		goods.setPrice(100);
		
		System.out.println("当前商品价格为：" + goods.getPrice());
		
		IGoods  salesDecoder4Goods = new SalesDecoder4Goods(goods);
		
		System.out.println("当前打8折后商品价格为：" + salesDecoder4Goods.getPrice());
	}
}
