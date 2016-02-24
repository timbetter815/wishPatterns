package head.template;

/**
 * TODO 模板模式：在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类在不改变算法结构的情况下，重新定义算法中的某些步骤。
 * 
 * ---- 模板模式实现：
 *   -- 1、定义抽象类，提供一个封装的模板方法（其中模板方法中调用一系列其他方法）
 *   -- 2、抽象类中，子类共用的方法，直接实现。如果必须子类实现的则定义为Abstract，如果是钩子方法则在子类中可以覆盖也可以不覆盖
 *   -- 3、所有自类继承自该抽象类
 *   
 * ---- jdk实现举例：
 *   -- 1、java。utils.sort
 *   
 * @author ttx
 * @since 2016年2月14日 下午7:21:56
 */
public class Client {

	public static void main(String[] args) {
		BrewBeverage brewBeverage = new Tea();
		brewBeverage.prepareBrewBeverage();
		
		brewBeverage = new Coffee();
		brewBeverage.prepareBrewBeverage();
	}
}
