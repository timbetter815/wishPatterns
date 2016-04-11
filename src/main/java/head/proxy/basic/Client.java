package head.proxy.basic;


/**
 * DESC 代理模式：为另一个对象提供替身或占位符以控制对这个对象的访问
 * 
 * ---- 代理模式有多种实现方式：
 *   -- 1、其中最简单的是使用Java的远程RMI代理实现。集成rmi.remote接口。
 *         使用lookup函数查找service服务，再service.sayHello()即可调用（本地调用远程堆的对象，通过网络返回）。
 *         
 *   -- 2、基本的代理模式实现：定义一个Subject接口，其他RealSubject、Proxy实现该接口，Proxy拥有RealSubject的一个引用，从而能通过调用Proxy来达到调用RealSubject目的
 *   
 *   
 * ---- 装饰者与代理模式，都是用一个对象把另外一个对象包起来，然后把调用委托给代理对象。
 *   -- 装饰者主要目的：为对象增加行为
 *   -- 代理模式目的： 控制对象访问
 *      
 *   
 *   
 * @author ttx
 * @since 2016年3月15日 上午11:02:40
 */
public class Client {

	public static void main(String[] args) {
		Subject realSubject = new RealSubject();
		Subject proxy = new BasicProxy(realSubject);
		proxy.request();
	}
}
