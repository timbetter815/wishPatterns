package chan.bridge;

/**
 * 桥梁模式：将抽象与其实现解耦，使它们可以独立的变化。
 *   --1、 将一组实现和另一组使用它们的对象分离。更确切的理解，应该是将一个事物中多个维度的变化分离。
 *   --2、 涉及到多维的变化，就可以使用桥梁模式。（其中的一维持有其他维度的对象引用）
 *   --3、 对应每一个维度定义一个接口，子类对应实现
 * 
 * 举例：service层，及dao层桥梁模式分析：
 *   -- 1、service层持有dao层的对象引用。
 *   -- 2、dao可以为hibnate或者mybatis。
 *   -- 3、dao层实现的变化与service层解耦
 *   -- 4、service的dao对象有spring依赖注入进去。供controller层使用
 *  
 * @author ttx
 * @since 2016年4月14日 下午11:55:34
 */
public class Client {

	public static void main(String[] args) {
		// 定义一个实例化角色
		Implementor implementor = new ConcreteImplementor1();
		// 定义一个抽象角色
		Abstraction abs = new RefinedAbstraction(implementor);
		// 执行
		abs.request();
	}
}
