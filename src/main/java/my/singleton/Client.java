package my.singleton;


/**
 * TODO 封装公用的单例框架（只需要传递Class类名，即可获得对应单例）
 *   -- 1、将单例工厂构造函数设置为私有方法（单例最基本的条件）
 *   -- 2、创建 static volatile 对象，new ConcurrentHashMap<Class, Object>(),用来保存需要的单例对象
 *   -- 3、每次调用getSingleton时候，先concurrentHashMap.get(ClassType),如果有则直接返回
 *   -- 4、如果没有，则使用双检，再使用反射将将构造函数设置为setAccessible，
 *   -- 5、然后obj = constructor.newInstance();创建，map.put(type, obj);
 *   
 *   -- 注：c++中可以使用宏定义实现单例
 *   
 * @author ttx
 * @since 2016年3月29日 上午11:32:57
 */
public class Client {
	public static Object singletonObj;
	
	public static void main(String[] args) {
		System.out.println("使用封装类似IOC（但是不自动类注解扫描） 单例结果： ");
		// 注：此处的MySingletonOne的构造函数为私有的，因此在单例工厂，需要将构造函数设置为setAccessible
		// 从而使用构造函数.newInstance来创建实例对象
		for(int i =0; i < 10; i++){
			singletonObj = SingletonFactory.getSingleton(MySingletonOne.class);
			System.out.println(singletonObj);
		}
		
	}
}
