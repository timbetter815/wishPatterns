package head.command;

public class ConcreteCommand implements Command {
	
	Receiver receiver;
	
	public ConcreteCommand(Receiver receiver){
		this.receiver = receiver;
	}

	public void excute() {
		receiver.action();
	}

	public void undo() {
	}

}
