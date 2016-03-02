package my.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonFactory {

	@SuppressWarnings("rawtypes")
	private static volatile Map<Class, Object> map = new ConcurrentHashMap<Class, Object>();

	private SingletonFactory() {
	}

	@SuppressWarnings("unchecked")
	public static <T> T getSingleton(Class<T> type) {
		Object obj = map.get(type);
		if (obj == null) {
			try {
				synchronized (SingletonFactory.class) {
					if (obj == null) {
						obj = type.newInstance();
						map.put(type, obj);
					}
				}
			} catch (Exception e) {
			}

		}
		return (T) obj;
	}
}
