package head.command;

public class Invoker {
	Command command;
	
	public void setCommand(Command command){
		this.command = command;
	}
	
	public void action(){
		command.excute();
	}
}
