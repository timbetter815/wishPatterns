package my.abstractFactory;

/**
 * TODO 工厂方法模式：定义了一个创建对象的接口，但是由子类决定要实例化的类是哪一个。工厂方法把类的实例化推迟到子类。
 * -- 1、定义一个抽象工厂方法类，所有的具体工厂类（AppleFactory、BananaFactory等）继承自该类
 * -- 2、定义一个抽象产品类（Fruit类）,所有的具体产品类继承自抽象产品类。
 * -- 3、抽象工厂方法类，有一个抽象工厂方法，返回值为抽象产品（即Fruit水果类）
 * -- 4、工厂方法将对象的创建延迟到具体实现工厂中，抽象工厂方法只是给出工厂接口
 * -- 5、抽象工厂，申明了工厂的一些方法（包括Factory方法的申明），所有工厂子类继承自抽象工厂，则将具体的工厂产生对象过程，放到了子类中实现
 * 
 * 
 * --- 工厂方法是依赖倒置，最有威力的技巧之一。这样高层模块只会依赖抽象高层接口对象，具体的实现有子类完成
 *   -- 依赖倒置几个指导原则（尽量遵循）：
 *   -- 1、变量不可持有具体类的引用。（如果直接使用new则持有了具体类的引用，可以采用工厂将new封装起来）
 *   -- 2、不要让类派生自具体类（应该派生自接口或者抽象类）
 *   -- 3、不要覆盖基类中已经实现的方法
 * 
 * 
 * ---- 假若需要扩展一个新的种类产品
 *   -- 1、需要创建该新产品的工厂类（该类继承自抽象工厂类）
 *   -- 2、需要创建该新产品的产品类（该类继承自抽象产品类）
 *   -- 这样不需要修改其他原有的业务逻辑，即增加了新的产品工厂（符合开闭原则）
 *   
 *   
 * ---- 工厂方法类实现要点：
 *   -- 首先定义一个抽象产品类，和一个抽象工厂类
 *   -- 所有具体产品都继承自抽象产品类。所有具体产品对应一个具体工厂类，所有具体工厂类都继承自抽象工厂类
 *   -- 抽象工厂接口类中提供一个Factory工厂方法，返回一个产品对象（返回类型必须是抽象类型，否则就会失去多态性）。
 *   -- 后续需要增加新产时：依照上述步骤，分类继承产品抽象类和工厂抽象类，及完成了扩展
 *   
 *   
 * ---- 工厂方法模式在java中应用：
 *   -- 示例1：java.util.Collection 中的iterator方法即为工厂方法，所有的继承自Collection类的具体类，必须提供iterator工厂方法，返回一个迭代对象，其中java.util.iterator为抽象工厂类
 *   -- 示例2：java.util.List 中的listIterator方法为工厂方法，所有继承自List类的具体类，必须提供listIterator工厂方法，返回一个迭代对象列表，其中java.util.List为抽象工厂类
 *   -- 示例3： java.util.URL中的openConnection为工厂方法，返回一个抽象类URLConnection对象。
 *   
 *   
 * ---- 并非所有的java中返回新对象则是工厂方法模式，例如toString、clone方法返回了新的对象，但是由于没法返回抽象的对象，因此不是工厂方法模式。
 * 
 * 
 * ---- 使用举例：使用工厂方法获取json、xml对象
 *   -- 1、创建一个抽象工厂httpFactory，定义一个抽象工厂方法get()。
 *   -- 2、定义两个工厂类，jsonFactory、xmlFactory，继承自httpFactory，
 *   -- 3、其中jsonFactory、xmlFactory的get工厂方法使用httpclient的Accept-type设置为json或者xml来获取对应的对象。
 *   -- 优点：
 *     -- 1、调用者，不需要关心底层具体细节，只需要new jsonFactory()或者 new xmlFactory()即可，则能获取特定的对象。
 *     -- 2、如果需要新增其他类型产品，直接继承httpFactory抽象工厂即可。
 *   -- 注：此处没有定义产品类，而是将产品类和工厂类合并了。
 * 
 * 
 * 无论是简单工厂模式、工厂模式还是抽象工厂模式，它们本质上都是将不变的部分提取出来，
 * 将可变的部分留作接口，以达到最大程度上的复用。拿一个生产水杯（cup）的工厂举例：
 * 起初，不用工厂模式，我必须在生产水杯之前知道水杯的材料和形状等水杯的所有特征才能生产，
 * 这就是我们的new Cup();这个Cup必须是具体的。厂主发现同一形状的被子，只是材料不同,
 * 如一个是玻璃(glass)的，一个是瓷(china)的,但是确要两条生产线，显然有资源浪费的嫌疑。
 * 现在厂主生产杯子时先不让生产线知道我要产的是玻璃的还是瓷的，而是让它在不知道具体材料的情况下先做它能做的，
 * 等到它把模具做好，只需要向其中填充玻璃原料或者瓷原料就可以造出同一形状的具体杯子了。
 * 但是很可惜，java并不能new一个抽象的Cup，所以就有了简单工厂模式。
 * 原来是Cup cup=new Cup;现在是SimpleCupFactory.createCup(String cupName),
 * 根据cup的名字生产Cup,而createCup返回的是一个实现了 Cup接口或抽象类的具体Cup。
 * 简单抽象工厂模式有一个问题，就是当我现在想生产一个同样形状的铁杯时，
 * 工厂里并没有定义相应的处理流程，只能更改createCup方法，这就不合理了。
 * 我现在只是想生产铁杯，你只要在最后的时候把玻璃原料换成铁的不就行了吗，
 * 干嘛还要更改整条生产线呢？于是就有了工厂模式。
 * 原来生产线在生产模具的时候还要考虑是为玻璃杯生产的模具还是为铁杯生产的模具，
 * 现在它不用管了。CupFactory.createCup()创建Cup.CupFactory是接口或抽象类。
 * 实现它的具体子类会创建符合Cup接口的具体Cup。那么现在厂主想要生产水壶(kettle)，
 * 用工厂模式就不得不再造一条水壶生产线，能不能在水杯生产线同时生产水壶呢？
 * 这就是抽象工厂模式。
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
































