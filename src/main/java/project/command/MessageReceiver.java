package project.command;

public class MessageReceiver implements Receiver {

	public void send() {
		System.out.println("I`m send a message from current user to someone...");
	}

	public void accept() {
		System.out.println("I`m accept a message");
	}

}
