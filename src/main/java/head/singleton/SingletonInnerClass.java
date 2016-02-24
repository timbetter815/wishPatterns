package head.singleton;

/**
 * TODO 使用java静态内部类实现单例
 * @author ttx
 * @since 2016年2月11日 下午4:18:10
 */
public class SingletonInnerClass {

	// 单例模式构造方法必须private私有化，才能禁止被多次new
	private SingletonInnerClass(){
	}
	
	private static class SingleHolder{
		private static SingletonInnerClass singletonInnerClass =  new SingletonInnerClass();
	}
	
	public static SingletonInnerClass getInstance(){
		return SingleHolder.singletonInnerClass;
	}
	
}
