package head.iterator;

/**
 * DESC 迭代器模式：提供一种方法顺序访问集合对象中的各个元素，而有不暴露其内部的实现
 * 
 * ---- 迭代器模式实现：
 *   -- 1、定义一个迭代器Iterator接口，接口含有至少两个方法hasNext()及next()
 *   -- 2、拥有一个普通集合类（该类没有iterator方法），想让该普通类支持iterator模式访问形式
 *   -- 3、创建一个2中普通类的具体迭代类，该具体迭代类，继承自迭代器Iterator接口，实现hasNext及next方法
 *   -- 4、在2中普通类中增加一个返回迭代器的方法Iterator iterator(),其中iterator方法即为：创建一个3中的具体迭代类对象
 *   -- 5、这样在Client端，即可以直接使用该对象obj.iterator()获取迭代器
 * 
 * 
 * @author ttx
 * @since 2016年2月15日 下午12:10:14
 */
public class Client {

	public static void main(String[] args) {
		CoustomTuple coustomTuple = new CoustomTuple();
		Iterator<?> coustomTupleIterator = coustomTuple.iterator();
		while(coustomTupleIterator.hasNext()){
			System.out.println(coustomTupleIterator.next());
		}
	}

}
