package my.simpleFactory;


/**
	 * TODO 简单工厂模式：将创建实例对象责任封装到工厂类中
	 * 
	 * -- 将对象的创建封装到工厂子类，例如水果工厂：每次传入 type =“apple”或者 type =“orange”则创建对象的苹果或者橘子。
	 * 
	 * 1、优点：将创建实例对象责任封装到工厂类中，客户端免除创建对象责任，只负责消费产品
	 * 2、缺点：如果增加产品种类，则需要修改工厂类，判断逻辑
	 * 
	 * --  java类库中简单工厂模式举例：java.text.DateFormat,其中DateFormat为一个抽象abstract类，里面有静态方法static getInstance，
	 *   --getInstance没法直接返回DateFormat自身实例对象（抽象类无法实例化），因此在getInstance里面get函数，
	 *   --封装返回了一个DateFormat的实现类SimpleDateFormat的实例。
	 *   
	 * -- 使用举例：简单工厂无处不在，只要涉及到将new对象封装到一个工厂函数，即为简单工厂
	 *
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
