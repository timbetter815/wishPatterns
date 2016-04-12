package project.command;

/**
 * DESC 将短信，邮件，通知的发送，接受使用命令模式
 *      -- 1、定义Command接口，其中SendCommand及acceptCommand继承自该接口，分别表示发送及接收命令，
 *            具体命令拥有一个Receiver成员变量，重写父类Command的excute方法
 *      -- 2、定义一个receiver接口，其中MailReceiver、MessageReceiver继承自该接口
 *      -- 3、定义一个Invoker调用中介者。拥有一个Command的成员变量。
 *      
 *      使用：
 *      -- 1、创建一个具体的MailReceiver，其中MailReceiver中定义了send及accept方法的具体业务逻辑
 *      -- 2、创建一个具体的SendCommand，其中SendCommand命令通过构造函数将发送命令与MailReceiver绑定
 *      -- 3、创建一个Invoker请求方，invoker通过setCommand设置上述命令
 *      -- 4、invoker执行action方法，则自动使得MailReceiver调用命令业务处理逻辑
 *      -- 5、从而达到了，将请求方Invoker与执行方Receiver解耦了。
 *      
 *      
 * @author ttx
 * @since 2016年4月11日 下午8:43:18
 */
public class Client {

	public static void main(String[] args) {
		
		Receiver receiver = new MailReceiver();
		Command command = new SendCommand(receiver);
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		invoker.action();
		
		receiver = new MessageReceiver();
		command = new SendCommand(receiver);
		invoker = new Invoker();
		invoker.setCommand(command);
		invoker.action();
		
		command = new AcceptCommand(receiver);
		invoker = new Invoker();
		invoker.setCommand(command);
		invoker.action();
		
	}
}
