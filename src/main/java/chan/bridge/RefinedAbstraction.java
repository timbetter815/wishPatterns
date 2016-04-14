package chan.bridge;

public class RefinedAbstraction extends Abstraction{

	RefinedAbstraction(Implementor implementor) {
		super(implementor);
	}

	// 修正父类的行为
	public void request(){
		super.request();
		super.getImplementor().doAnything();
	}
}
