package head.javaiterator;


/**
 * TODO 迭代器模式：提供一种方法顺序访问集合对象中的各个元素，而有不暴露其内部的实现
 * 
 * ---- 迭代器模式使用java.utils.Iterator 及java.lang.Iterable 实现：
 *   -- 1、实现了java.lang.Iterable的接口的类，可以使用java5的for/in新语法实现，迭代器遍历
 *   -- 2、java5的for/in，实际上编译器最终会变为调用Iterator方式实现遍历
 * 
 * 
 * @author ttx
 * @since 2016年2月15日 下午12:10:14
 */
public class Client {

	public static void main(String[] args) {
		CoustomJavaTuple coustomTuple = new CoustomJavaTuple();
		
	
		for(String str : coustomTuple){
			System.out.println(str);
		}
	}

}
