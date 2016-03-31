package head.command;

/**
 * TODO 命令模式：将"请求"封装成对象，以便使用不同的请求、队列、或者日志来参数化其他对象。命令模式也支持可撤销的操作。
 * ---- 命令模式实现：
 *   -- 1、定义一个命令接口，命令接口有excute方法。
 *   -- 2、具体命令对象继承自命令接口，其中具体命令对象持有一个Receiver对象，在构造函数中赋值（也可以使用初始值+构造函数赋值同时使用），
 *   --    表明该命令的接收者关系。其中excute方法，调用Receiver对象的action方法
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
 * ---- 命令模式优缺点：
 *   -- 1、命令模式允许请求的一方和接收的一方独立开来，使得请求的一方不必知道接收请求的一方的接口，
 *         更不必知道请求是怎么被接收以及操作是否被执行、何时执行、如何执行的；
 *   -- 2、命令模式使新的命令很容易的被加到系统里；
 *   -- 3、允许接收请求的一方决定是否要否决请求；
 *   -- 4、能够较容易的设计一个命令队列；
 *   -- 5、可以很容易的实现对一个命令的Undo和Redo；
 *   -- 6、在需要的情况下可以很容易的将命令记入日志；
 *   -- 7、在C语言中命令模式便是面向对象形式的回呼（Callback）。
 *   
 * ---- jdk 命令模式使用场景：
 *   -- 1、java.util.Timer#schedule()与cancel()，其中Timer为Command接口
 *         timer = new Timer(); timer.schedule(new RemindTask(), seconds*1000);及timer.cancel(); 
 *         
 *   -- 2、短信、邮件、公告发送接口，定义一个sendCommand接口
 *         noticeCommand接口，里面有send()方法，里面拥有一个static ReceiverList = new ArrayList();及addReceiver(){}方法
 *         其中短信、邮件、公告实现sendCommand，各自定义自己的send()方法。
 *         每次前端页面请求发送短信或者邮件，输入了电话号码或者邮箱地址后，则自动创建一个new Receive();其中Receive中保存了介绍通知的人的名字及其他信息
 *         如果点击的是短信，则创建一个短信命令对象。创建短信发送命令对象同时，需要传递Receive对象。再通过send将Receive及当前发件人信息，拼装成信息内容。
 *         这样当以后有新的类型发送命令，只需要扩展一个新的具体命令，重写send方法即可。
 *         
 *   -- 3、导航下一步：每次单击下一步生成一个命令，使用invoker.setCommand保存起来。当最后一步点击提交完成实现send(),send()方法依次将所有步骤执行。
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
