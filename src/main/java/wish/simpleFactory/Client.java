package wish.simpleFactory;


/**
	 * TODO 此处即简单工厂模式：
	 * 1、优点：将创建实例对象责任封装到工厂类中，客户端免除创建对象责任，只负责消费产品
	 * 2、缺点：如果增加产品种类，则需要修改工厂类，判断逻辑
	 * --  java类库中简单工厂模式举例：java.text.DateFormat,其中DateFormat为一个抽象abstract类，里面有静态方法static getInstance，
	 *   --getInstance没法直接返回DateFormat自身实例对象（抽象类无法实例化），因此在getInstance里面get函数，
	 *   --封装返回了一个DateFormat的实现类SimpleDateFormat的实例。
 * @author ttx
 * @since 2016年2月11日 上午11:56:45
 */
public class Client {
	
	public static void main(String[] args) {
		String fruitType = "apple";
		Fruit fruit = SimpleFactory.FruitFacory(fruitType);
		fruit.plant();
		
		fruitType = "banana";
		fruit = SimpleFactory.FruitFacory(fruitType);
		fruit.plant();
		
/*		此处添加了新的种类水果，则需要修改静态工厂类方法的判断逻辑，否则会抛出异常
		fruitType = "otherFruit";
		fruit = SimpleFactory.FruitFacory(fruitType);
		fruit.plant();*/
		
	}
}
