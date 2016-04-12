package head.decorator;

/**
 * DESC 装饰者模式：动态的将责任附加到对象上。想要扩展功能，装饰者提供有别于继承的另一种选择
 * 
 * ---- 装饰者的实现：
 *   -- 1、装饰者模式中 主类（即饮料）和 装饰者类（即调料类），都继承自同一个超类（饮料类）（只有继承自同一个超类，才能进行装饰）
 *   -- 2、装饰者类拥有一个主类的对象，该对象在装饰者类初始化构造函数中赋值（即：每次装饰者被被包装时，需要将当前想要包装的类作为构造参数传递给装饰者对象）
 *   -- 3、由于主类和装饰者类拥有相同的超类，因此装饰者类可以使用构造函数传递进来的被装饰对象的所有对象方法
 *   
 *   
 * ---- 装饰者类缺点：出现了大量的装饰者小类
 * 
 * 
 * ---- 使用案例：普通商品goods和使用salesDecoratorOrder装饰后的打折商品getPrice被装饰为返回打折后价格（适应于满减等活动）
 *   -- 1、定义一个SalesDecoder4Goods装饰类，持有一个普通Order的对象引用。
 *   -- 2、其中SalesDecoder4Goods具有和普通订单一样的方法，使用持有Order对象来委托求出具体值
 *   -- 3、在getPrice时候，可以动态增加打折的职责来获取打折后的价格
 * 
 * ---- jdk中的实现：
 *   -- java.io.FileInputStream（new BufferedReader(new InputStreamReader(System.in));）
 *   
 * @author ttx
 * @since 2016年2月11日 上午12:24:31
 */
public class Client {

	public static void main(String[] args) {
		// 创建一种浓缩咖啡
		Beverage beverage = new Espresso();
		System.out.println("当前饮料为：" + beverage.getDiscription() + " 价格为： " + beverage.getCost());
		
		// 浓缩咖啡里面加牛奶
		beverage = new Milk(beverage);
		System.out.println("当前饮料为：" + beverage.getDiscription() + " 价格为： " + beverage.getCost());
		
		// 再加上摩卡
		beverage = new Mocha(beverage);
		System.out.println("当前饮料为：" + beverage.getDiscription() + " 价格为： " + beverage.getCost());
	}

}
