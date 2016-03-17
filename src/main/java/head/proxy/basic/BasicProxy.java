package head.proxy.basic;

public class BasicProxy implements Subject {

	Subject subject;
	
	public BasicProxy(Subject subject){
		this.subject = subject;
	}
	
	public void request() {
		subject.request();
	}

}
