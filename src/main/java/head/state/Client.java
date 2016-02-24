package head.state;

/**
 * TODO 状态模式：允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它的类
 *   -- 1、将每个状态的行为局部化到自己的状态类中
 *   -- 2、让每一种状态对修改关闭，对扩展开放（可以自由新增加状态（继承自state即可））
 *   -- 3、缺点：大量的状态子类
 *   
 * ---- 状态模式实现：
 *   -- 1、定义一个context（上下文）类，它可以拥有一些内部状态。该类持有state接口类对象的引用及state接口的方法
 *   -- 2、定义个一个state接口，接口中定义所有的行为方法
 *   -- 3、其他所有具体状态类继承自state接口，其中每一个具体类，持有一个context的引用对象，用来改变context当前的状态（通过context类的setState方法）
 *   
 * 
 * ---- 状态模式 VS 策略模式：
 *   -- 状态模式 与 策略模式 的UML类图是一致的。
 *   -- 策略模式：围绕着可以互换的算法来创建成功的业务。
 *   -- 策略模式实现：将flyBehavior独立成接口从duck对象中独立出来，duck对象拥有flyBehavior的引用。
 *              从而不同的鸭子继承duck时候，构造函数将flyBehavior实例化为具体的行为（FlyWithWings或者FlyNoWay等）
 *   -- 状态模式：通过改变对象内部状态来帮助对象控制自己的行为。
 *            
 * @author ttx
 * @since 2016年2月19日 下午9:22:49
 */
public class Client {

	public static void main(String[] args) {
		int gumballNum = 10;
		// 由于状态太多，有些状态代码没有补全（此处仅为示例）
		GumballMachine GumballMachine = new GumballMachine(gumballNum);
		
		// 每次投币，转动曲柄，则会自动售出一颗糖果，糖果机状态自己变化
		GumballMachine.insertQuarter();
		GumballMachine.tumCrank();
		
		GumballMachine.insertQuarter();
		GumballMachine.tumCrank();
	}

}
