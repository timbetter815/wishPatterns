package project.command;

public class MailReceiver implements Receiver {

	public void send() {
		System.out.println("I`m send a mail from current user to someone...");
	}

	public void accept() {
		System.out.println("I`m read the mail");
	}

}
