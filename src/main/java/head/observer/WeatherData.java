package head.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

	// 定义一个list保存所有观察者对象
	List<Observer> ObserverList = new ArrayList<Observer>();
	
	// 观察者注册到该主题subject对象
	public void addObserver(Observer observer) {
		ObserverList.add(observer);
	}

	// 将观察者从当前注册list中剔除
	public void removeObserver(Observer observer) {
		ObserverList.remove(observer);
	}

	// 向所有注册观察者发布通知
	public void notifyObserver() {
		for(Observer observer : ObserverList){
			observer.update();
		}
	}

}
