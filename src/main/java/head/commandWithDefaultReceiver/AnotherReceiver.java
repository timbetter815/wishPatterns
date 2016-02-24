package head.commandWithDefaultReceiver;

public class AnotherReceiver implements Receiver {

	public void action() {
		System.out.println("I'm another receiver, I have receive the command and has excute it!!!");
	}

}
