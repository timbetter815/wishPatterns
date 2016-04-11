package my.abstractFactory;

/**
 * DESC 抽象工厂模式：提供一个接口（抽象工厂里面提供产品族对象获取的抽象接口），用于创建相关或依赖对象的家族，而不需要明确指定具体类
 * -- 1、定义一个抽象工厂方法类，并定义一系列生产各产品族的工厂方法（createFruit，crateVeggie等），所有的具体工厂类继承自该类，并重写抽象工厂方法
 * -- 2、定义多个抽象产品（Fruit、Veggie等产品族）,所有的具体产品类继承自各自抽象产品类（热带水果，热带蔬菜，寒带水果，寒带蔬菜）。
 * -- 3、多个产品族，对应多个产品族工厂，即NorthernGardenerFactory、TropicalGardenerFactory。
 * -- 4、其中TropicalGardenerFactory重写createFruit，crateVeggie方法，对应生产热带水果，热带蔬菜。同理NorthernGardenerFactory()类同。
 * -- 4、工厂方法将对象的创建延迟到具体实现工厂中，抽象工厂方法只是给出工厂接口
 * -- 5、抽象工厂，申明了工厂的一些方法（包括Factory方法的申明），所有工厂子类继承自抽象工厂，则将具体的工厂产生对象过程，放到了子类中实现
 * -- 6、如果有N个产品族，则在抽象工厂方法中就应该定义N个创建方法。
 * 
 * ---- 工厂方法 VS 抽象工厂
 *   -- 1、工厂方法，定义了一个创建对象的接口，但是由子类决定要实例化的类是哪一个。工厂方法把类的实例化推迟到子类。
 *   -- 2、抽象工厂，定义一个接口，用于创建一个产品对象家族（即抽象工厂接口中，定义了创建各家族产品的抽象方法，而工厂方法，只有一个获取单一产品的接口方法）。
 *   -- 3、工厂方法，支持动态扩展添加产品，而不需修改已有代码结构。（只需要简单继承抽象产品与抽象工厂，增加具体产品类和具体工厂类即可）
 *   -- 4、抽象工厂，支持动态扩展添加产品线(但不能增加新产品，因为增加新产品需要)，而不需修改已有代码结构。
 *     -- 举例：已经具有热带工厂、寒带工厂、但是热带工厂和寒带工厂都只能生产水果和蔬菜（因为在抽象工厂中定义了createFruit，crateVeggie）
 *     -- 如果想要增加一个新的产品线（即产品等级是非常容易扩展的），温带工厂，只需要温带工厂继承自抽象工厂，
 *     -- 重写createFruit，crateVeggie即可（当然产生的水果和蔬菜是温带性质的），当然需要增加温带水果，和温带蔬菜（分别继承自Fruit和Veggie）
 *     
 *  
 * ---- jdk抽象工厂示例（一个创建新对象的方法，返回的却是接口或者抽象类的，就是抽象工厂模式了）：
 *   -- 1、 java.util.Calendar#getInstance()
 *   -- 2、其中Calendar相当于抽象工厂类，其中static方法getInstance调用了createCalendar，
 *   -- 3、createCalendar根据不同的条件创建不同的具体产品BuddhistCalendar、JapaneseImperialCalendar以及GregorianCalendar
 *   -- 4、而createCalendar返回的接口依然是抽象产品接口Calendar。
 *   -- 5、这里的抽象工厂（Calendar类）和抽象产品（Calendar类）是同一个类，但我们依然认为calendar是一个抽象工厂的实现
 *   
 *   -- java.sql.DriverManager#getConnection()产品族为oracle、mysql、sqlserver，每一个产品族里面有相应的setAutoCommit()、rollback()等一系列方法。

 *   
 * 
 *   无论是简单工厂模式、工厂模式还是抽象工厂模式，它们本质上都是将不变的部分提取出来，将可变的部分放入到接口内实现，以达到最大程度上的复用。
 *   -- 拿一个生产水杯（cup）的工厂举例：
 *     -- 起初，不用工厂模式，我必须在生产水杯之前知道水杯的材料和形状等水杯的所有特征才能生产，这就是我们的new Cup();这个Cup必须是具体的。
 *     -- 厂主发现同一形状的被子，只是材料不同,如一个是玻璃(glass)的，一个是瓷(china)的,但是确要两条生产线，显然有资源浪费的嫌疑。
 *     -- 现在厂主生产杯子时先不让生产线知道我要产的是玻璃的还是瓷的，而是让它在不知道具体材料的情况下先做它能做的，等到它把模具做好，
 *     -- 只需要向其中填充玻璃原料或者瓷原料就可以造出同一形状的具体杯子了。但是很可惜，java并不能new一个抽象的Cup，所以就有了简单工厂模式。
 *     -- 原来是Cup cup=new Cup;现在是SimpleCupFactory.createCup(String cupName),根据cup的名字生产Cup,而createCup返回的是一个实现了 Cup接口或抽象类的具体Cup。
 *     -- 简单抽象工厂模式有一个问题，就是当我现在想生产一个同样形状的铁杯时，工厂里并没有定义相应的处理流程，只能更改createCup方法，这就不合理了。
 *     -- 我现在只是想生产铁杯，你只要在最后的时候把玻璃原料换成铁的不就行了吗，干嘛还要更改整条生产线呢？于是就有了工厂模式。
 *     -- 原来生产线在生产模具的时候还要考虑是为玻璃杯生产的模具还是为铁杯生产的模具，现在它不用管了。CupFactory.createCup()创建Cup.CupFactory是接口或抽象类。
 *     -- 实现它的具体子类会创建符合Cup接口的具体Cup。那么现在厂主想要生产水壶(kettle)，
 *     -- 用工厂模式就不得不再造一条水壶生产线，能不能在水杯生产线同时生产水壶呢？这就是抽象工厂模式。
 *     
 * @author ttx
 * @since 2016年3月28日 上午10:55:31
 */
public class Client {
	
	public static void main(String[] args) {
		GardenerFactory gardenerFactory = new NorthernGardenerFactory();
		Fruit fruit = gardenerFactory.createFruit();
		Veggie veggie = gardenerFactory.createVeggie();
		
		System.out.println("The NorthernGardenerFactory create the follows product:");
		System.out.println(fruit.getName());
		System.out.println(veggie.getName());
		
		
		gardenerFactory = new TropicalGardenerFactory();
		fruit = gardenerFactory.createFruit();
		veggie = gardenerFactory.createVeggie();
		System.out.println("\n\nThe TropicalGardenerFactory create the follows product:");
		System.out.println(fruit.getName());
		System.out.println(veggie.getName());
	}
}
































