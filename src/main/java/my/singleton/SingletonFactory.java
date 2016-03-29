package my.singleton;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonFactory {

	@SuppressWarnings("rawtypes")
	private static volatile Map<Class, Object> concurrentHashMap = new ConcurrentHashMap<Class, Object>();

	private SingletonFactory() {
	}

	@SuppressWarnings("unchecked")
	public static <T> T getSingleton(Class<T> type) {
		Object obj = concurrentHashMap.get(type);
		if (obj == null) {
			try {
				synchronized (SingletonFactory.class) {
					if (obj == null) {
						// 使用反射将私有构造函数设置为可访问
						Constructor<?>[] constructors = type.getDeclaredConstructors();
						AccessibleObject.setAccessible(constructors, true); 
						for(Constructor<?> constructor : constructors){
							if(constructor.isAccessible()){
								// 使用newInstance来根据class创建实例对象
								obj = constructor.newInstance();
								concurrentHashMap.put(type, obj);
							}
						}
					}
				}
			} catch (Exception e) {
			}
		}
		return (T) obj;
	}
}
