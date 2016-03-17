package head.proxy.basic;

public class RealSubject implements Subject {

	public void request() {
		System.out.println("I'm the real subject, i'm doing the request.");
	}

}
