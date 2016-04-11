package my.command;

public class SendCommand implements Command{
	
	private Receiver receiver;
	
	public SendCommand(Receiver receiver){
		this.receiver = receiver;
	}

	public void execute() {
		receiver.send();
	}

}
