package head.singleton;

/**
 * TODO 单例模式：确保一个类只有一个实例，提供一个全局访问点
 * ---- 单例模式实现：
 *   -- 1、单例模式分为两种：1、懒汉模式     2、饿汉模式（即延迟加载）
 *   -- 2、单例模式保证为单例最重要的特征即：构造方法private私有化
 *   -- 3、 如果看到单例延迟加载模式， 需要考虑双检（spring的单例也使用的双检实现单例）
 *   
 *   -- 单例具体实现方式多种：
 *   -- 1、懒汉模式：直接在单例类定义一个final static 单例变量
 *   -- 2、延迟加载模式：使用synchronized锁住getInstance方法（判断instance是否为null，为null则new ，不为null则直接返回即可）
 *   -- 3、直接方法级别同步  synchronized 加锁，效率低，考虑用双重检查加锁机制（注意单例变量加上volatile修改，且需要在jdk1.5之后才能保证正确性）
 *   -- 4、使用静态内部类实现（任然是延迟加载但是模式）：静态内部类创建并持有一个单例对象。getInstance中返回静态类只有的单例对象即可
 * 
 * @author ttx
 * @since 2016年2月11日 下午2:50:47
 */
public class Client {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//获取一个单例对象（此处使用的是懒汉模式，即每次在类初始化时候，该单例即被创建出来）
		Singleton singleton = Singleton.getInstance();
		
		
		//下述方式都是使用的是饿汉模式，即只有当需要使用时候，该单例才被创建出来，即延迟加载单例模式（节省了资源，例如有些单例被不被使用，则不会被创建出来）
		
		// 将整个方法synchronized锁住（效率较低）
		SingletonLazy singletonLazy =  SingletonLazy.getInstanceWarn1();
		
		
		// 使用了著名的双重锁检查机制（但是只适用于jdk1.5以后版本）
		// 为什么相对于getInstanceWarn1效率更高呢？因此双重检查的锁只有在第一次创建对象起作用，对于后面单例对象获取不会进入同步代码，直接获取的单例对象
		singletonLazy =  SingletonLazy.getInstanceWarn2();
		
		// 此处使用静态内部类实现延迟加载单例模式
		// 实现方式：即在单例类中创建一个静态内部类，来new 单例对象，然后在getInstance方法中调用该静态类创建持有的单例对象
		SingletonInnerClass singletonInnerClass = SingletonInnerClass.getInstance();
		
		
	}
}
