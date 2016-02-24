package head.commandWithDefaultReceiver;

public class ConcreteCommandWithDefaultReceiver extends CommandWithDefaultReceiver {

	// 此处为默认构造函数，默认new DefaultReceiver为该命令接受对象
	public ConcreteCommandWithDefaultReceiver() {
		super(new DefaultReceiver());
	}
	
	// 此处为覆盖默认Receiver对象
	public ConcreteCommandWithDefaultReceiver(Receiver receiver) {
		super(receiver);
	}

	@Override
	void excute() {
		receiver.action();
	}

}
