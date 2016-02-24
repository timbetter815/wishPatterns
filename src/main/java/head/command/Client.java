package head.command;

/**
 * TODO 命令模式：将"请求"封装成对象，以便使用不同的请求、队列、或者日志来参数化其他对象。命令模式也支持可撤销的操作。
 * ---- 命令模式实现：
 *   -- 1、定义一个命令接口，命令接口有excute方法。
 *   -- 2、具体命令对象继承自命令接口，其中具体命令对象持有一个Receiver对象，在构造函数中赋值（也可以使用初始值+构造函数赋值同时使用），表明该命令的接收者关系。其中excute方法，调用Receiver对象的action方法
 *   -- 3、定义一个Receiver对象（也可以定义Receiver接口，具体Receiver对象继承自该Receiver接口），具有一个action方法，此action方法是真正接受命令干事的方法
 *   -- 4、定义一个Invoker类，此类即命令的调用者，具有setCommand方法，该方法用于将该客户端发送命令
 *   -- 5、Client端，需要new Invoker 与 Receiver 对象。
 *        然后new 一个具体的Command对象（new具体Command对象时，传递构造参数Receiver对象）。
 *        再将该Command对象，setCommand到Invoker对象。在执行command对象的excute方法
 *        
 * ---- 假若想要支持undo方式：
 *   -- 1、以设置电影快进速度为例：电影快进速度有x1/x2/x3三个速度
 *   -- 2、每次设置速度即执行command的excute时候，记录最近一次的快进速度保存到变量lastSpeed
 *   -- 3、当invoker对象调用undo时候，则将速度恢复为lastSpeed即可
 *        
 * @author ttx
 * @since 2016年2月13日 下午3:26:48
 */
public class Client {

	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		
		Invoker invoker = new Invoker();
		
		// 此处传递receiver对象，绑定该ConcreteCommand命令与执行者receiver的绑定关系
		Command command = new ConcreteCommand(receiver);
		
		invoker.setCommand(command);

		command.excute();
	}

}
