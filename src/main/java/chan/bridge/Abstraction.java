package chan.bridge;

public abstract class Abstraction {

	private Implementor implementor;
	
	Abstraction(Implementor implementor){
		this.implementor = implementor;
	}

	// 自身的行为和属性
	public void request(){
		this.implementor.doSomething();
	}
	
	// 获取实例化角色
	public Implementor getImplementor() {
		return implementor;
	}
}
