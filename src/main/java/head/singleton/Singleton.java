package head.singleton;

public class Singleton {
	private static Singleton singleton =  new Singleton();

	// 丹丽模式构造方法必须private私有化，才能禁止被多次new
	private Singleton(){
	}
	
	// 通过一个静态方法来获取单例对象
	public static Singleton getInstance(){
		return singleton;
	}
}
