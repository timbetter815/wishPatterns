package head.strategy;

/**
 * DESC 策略模式：定义了算法族，分别封装起来，让它们之间可以互相替换，此模式让算法的变化独立于使用算法的客户。
 * 
 * ---- 策略模式实现：
 *   -- 1、定义一个context类（duck），定义自己的行为方法（fly()/quack()），context里面持有FlyBehavior接口对象引用
 *   -- 2、定义FlyBehavior行为接口，其他Fly行为类继承自FlyBehavior（FlyWithWings、FlyNoWay等）
 *   -- 3、具体的context类继承自context类，例如RedHeadDuck、ToyDuck。其中子类将父类duck中持有的接口引用对象赋值为具体行为类（例如：FlyWithWings、FlyNoWay等）
 *   -- 4、这样在new 具体的context子类时，其行为则自动生成。
 *   
 * ---- 项目中策略模式：
 *   -- 其中baseclient定义get、put、post、delete接口。
 *   -- novaclient/neutronclient/cindercllient继承自baseclient，
 *   -- 各自的算法get、put、post、delete相同，但是端口，版本号不相同，但是互相可以替换
 *   -- 其他NovaManage中持有baseclient的引用，这样可以new novaclient及neutronclient等来调用不同的CURD方法。
 *   
 * @author ttx
 * @since 2016年2月19日 下午11:09:24
 */
public class Client {

	public static void main(String[] args) {
		Duck duck = new RedHeadDuck();
		duck.fly();
		
		duck = new ToyDuck();
		duck.fly();
	}

}
