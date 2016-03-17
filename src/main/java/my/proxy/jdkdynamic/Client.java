package my.proxy.jdkdynamic;

/**
 * TODO jdk动态代理模式
 * 
 * ---- 1、创建接口MyInvocationHandler 实现 jdk InvocationHandler接口，将需要对原生对象增加的切入点放置到MyInvocationHandler该实现类中
 *   -- 2、在MyInvocationHandler中，实现getProxy函数，该函数用newProxyInstance生成并返回代理类（newProxyInstance需要使用MyHello作为参数）
 *   -- 3、在Client端，new一个将要被代理的原始对象MyHello，将该对象以构造传参形式，传递给MyInvocationHandler
 *   -- 本例中在MyInvocationHandler中实现了before、after切入函数。因此proxy.sayHello（）调用时候，动态代理自动调用切点函数
 * 
 * @author ttx
 * @since 2016年3月17日 下午2:38:55
 */
public class Client {
	
	public static void main(String[] args) {
		Hello hello = new MyHello();
		
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler(hello);
		
		Hello proxy = (Hello)myInvocationHandler.getProxy();
		
		proxy.sayHello();
	}

}
