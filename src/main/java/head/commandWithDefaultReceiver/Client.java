package head.commandWithDefaultReceiver;

public class Client {
	public static void main(String[] args) {
		Invoker invoker = new Invoker();
		// 使用默认Receiver对象执行命令
		CommandWithDefaultReceiver commandWithDefaultReceiver = new ConcreteCommandWithDefaultReceiver();
		invoker.setCommand(commandWithDefaultReceiver);
		invoker.action();
		
		// 使用非默认Receiver对象执行命令
		commandWithDefaultReceiver = new ConcreteCommandWithDefaultReceiver(new AnotherReceiver());
		invoker.setCommand(commandWithDefaultReceiver);
		invoker.action();
	}
}
