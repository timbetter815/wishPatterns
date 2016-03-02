package my.singleton;

public class Client {
	public static Object singletonObj;
	
	public static void main(String[] args) {
		System.out.println("BaseSingleton 单例结果： ");
		for(int i =0; i < 10; i++){
			singletonObj = SingletonFactory.getSingleton(MySingletonOne.class);
			System.out.println(singletonObj);
		}
		
		System.out.println("\n\nBaseSingleton 由于构造方法为protected，因此可以直接new，不符合单例，结果：");
		

	}
}
