package head.commandWithDefaultReceiver;

public class Invoker {
	
	CommandWithDefaultReceiver commandWithDefaultReceiver;
	
	void setCommand(CommandWithDefaultReceiver commandWithDefaultReceiver){
		this.commandWithDefaultReceiver = commandWithDefaultReceiver;
	}
	
	void action(){
		commandWithDefaultReceiver.excute();
	}
}
