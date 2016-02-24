package head.commandWithDefaultReceiver;

public abstract class CommandWithDefaultReceiver{
	
	// 此处定义一个Receiver对象
	Receiver receiver;
	
	// 为Receiver赋新值
	public CommandWithDefaultReceiver(Receiver receiver){
		this.receiver = receiver;
	}
	
	abstract void excute();
	
	void undo(){};
}
