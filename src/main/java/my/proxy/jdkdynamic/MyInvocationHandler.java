package my.proxy.jdkdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
	public Object target;

	public MyInvocationHandler(Object target){
		this.target = target;
	}
	
	public Object getProxy(){
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		
		Object result = method.invoke(target, args);
		
		after();
		
		return result;
	}
	
	public void before(){
		System.out.println("Before say hello, I must kown you name.");
	}

	public void after(){
		System.out.println("After say hello, I say goodbye when i leave.");
	}
}
