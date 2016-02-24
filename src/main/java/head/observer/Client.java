package head.observer;

/**
 * TODO 观察者对象：定义了对象间的一对多的依赖，这样依赖当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新。
 * 
 * ---- 实现总结：
 *   -- 1、定义一个Subject主题对象接口及一个Observer观察者接口
 *   -- 2、Subject主体对象接口，定义一个List 保存所有的Observer对象。 拥有 addObserver、removeObserver、notifyObserver三个方法
 *   -- 3、Observer对象接口，拥有update方法，该方法在Subject主题对象，通知所有观察者时候自动调用
 *   -- 4、其中具体的主题对象，及观察者对象实现Subject及Observer接口
 *   
 * ---- 其他方式实现观察者：
 *   -- 继承自jdk的java.util.Observer 及java.util.Observable 接口即可 
 * @author ttx
 * @since 2016年2月10日 下午11:42:06
 */
public class Client {
	
	public static void main(String[] args) {
		// 创建一个现实当前数据的观察者对象
		Observer observer = new CurrentDataDisplay();
		
		// 创建一个气象数据的主题对象
		Subject subject = new WeatherData();
		// 添加观察者对象到气象数据主题对象
		subject.addObserver(observer);
		// 主题对象通知所有观察者对象
		subject.notifyObserver();
	}
}
