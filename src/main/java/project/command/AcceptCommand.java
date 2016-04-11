package project.command;

public class AcceptCommand implements Command{
	
	private Receiver receiver;
	
	public AcceptCommand(Receiver receiver){
		this.receiver = receiver;
	}

	public void execute() {
		receiver.accept();
	}

}
