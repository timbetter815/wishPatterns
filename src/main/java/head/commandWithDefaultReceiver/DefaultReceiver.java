package head.commandWithDefaultReceiver;

public class DefaultReceiver implements Receiver {

	public void action() {
		System.out.println("I'm the default receiver, I have receive the command and has excute it!!!");
	}

}
