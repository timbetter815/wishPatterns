package my.proxy.jdkdynamic;

/**
 * TODO jdk动态代理模式
 * ---- 1、创建接口MyInvocationHandler 实现 jdk InvocationHandler接口，将需要对原生对象增加的切入点放置到MyInvocationHandler该实现类中
 *   -- 2、在MyInvocationHandler中，重写invoke()方法，将切点方法放置到method.invoke()前后即可，
 *    --3、实现getProxy函数，该函数用newProxyInstance生成并返回代理类（newProxyInstance需要使用MyHello作为参数）
 *   -- 4、在Client端，new一个将要被代理的原始对象MyHello，将该对象以构造传参形式，传递给MyInvocationHandler
 *   
 *   -- 本例中在MyInvocationHandler中实现了before、after切入函数。因此proxy.sayHello（）调用时候，动态代理自动调用切点函数
 * 
 * @author ttx
 * @since 2016年3月17日 下午2:38:55
 */
public class Client {
	
	public static void main(String[] args) {
		Hello hello = new MyHello();
		
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler(hello);
		
		Hello proxy = (Hello)myInvocationHandler.getProxy();
		
		proxy.sayHello();
	}
/**  
     * TODO 此处附上对于jdk动态代理的 核心函数newProxyInstance解析
	 * @author ttx
	 * @since 2016年3月17日 下午2:38:55
	 */
    /*分析代码函数：1
     * @CallerSensitive
    public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
        throws IllegalArgumentException
    {
        // 判断是否为空
        if (h == null) {
            throw new NullPointerException();
        }

		// 获取安全管理器，检查权限
        final SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            checkProxyAccess(Reflection.getCallerClass(), loader, interfaces);
        }

        
         * Look up or generate the designated proxy class.
         // 获取需要被代理的原始对象类 跟进到1-1
        Class<?> cl = getProxyClass0(loader, interfaces);

        
         * Invoke its constructor with the designated invocation handler.
         
        try {
            // 调用被代理类的构造方法
            final Constructor<?> cons = cl.getConstructor(constructorParams);
            final InvocationHandler ih = h;
            if (sm != null && ProxyAccessHelper.needsNewInstanceCheck(cl)) {
                // create proxy instance with doPrivilege as the proxy class may
                // implement non-public interfaces that requires a special permission
                return AccessController.doPrivileged(new PrivilegedAction<Object>() {
                    public Object run() {
                        return newInstance(cons, ih);
                    }
                });
            } else {
                return newInstance(cons, ih);
            }
        } catch (NoSuchMethodException e) {
            throw new InternalError(e.toString());
        }
    }*/
	
	
   /**分析代码函数：1-1
     * Generate a proxy class.  Must call the checkProxyAccess method
     * to perform permission checks before calling this.
     */
    /*private static Class<?> getProxyClass0(ClassLoader loader,
                                           Class<?>... interfaces) {
        // 限制实现代理的类接口实现类必须少于65535个
        if (interfaces.length > 65535) {
            throw new IllegalArgumentException("interface limit exceeded");
        }

        Class<?> proxyClass = null;

         collect interface names to use as key for proxy class cache 
        String[] interfaceNames = new String[interfaces.length];

        // for detecting duplicates
        Set<Class<?>> interfaceSet = new HashSet<>();

		// 遍历目标类所有实现接口
        for (int i = 0; i < interfaces.length; i++) {
            
             * Verify that the class loader resolves the name of this
             * interface to the same Class object.
            // 获取目标类实现接口名称 
            String interfaceName = interfaces[i].getName();
            Class<?> interfaceClass = null;
            try {
                // 加载目标类实现的接口到内存中  
                interfaceClass = Class.forName(interfaceName, false, loader);
            } catch (ClassNotFoundException e) {
            }
            if (interfaceClass != interfaces[i]) {
                throw new IllegalArgumentException(
                    interfaces[i] + " is not visible from class loader");
            }

            
             * Verify that the Class object actually represents an
             * interface.
             
            if (!interfaceClass.isInterface()) {
                throw new IllegalArgumentException(
                    interfaceClass.getName() + " is not an interface");
            }

            
             * Verify that this interface is not a duplicate.
             
            if (interfaceSet.contains(interfaceClass)) {
                throw new IllegalArgumentException(
                    "repeated interface: " + interfaceClass.getName());
            }
            interfaceSet.add(interfaceClass);

            interfaceNames[i] = interfaceName;
        }
        
        
        
         * Using string representations of the proxy interfaces as
         * keys in the proxy class cache (instead of their Class
         * objects) is sufficient because we require the proxy
         * interfaces to be resolvable by name through the supplied
         * class loader, and it has the advantage that using a string
         * representation of a class makes for an implicit weak
         * reference to the class.
         
        List<String> key = Arrays.asList(interfaceNames);

        
         * Find or create the proxy class cache for the class loader.
         
        Map<List<String>, Object> cache;
        synchronized (loaderToCache) {
            cache = loaderToCache.get(loader);
            if (cache == null) {
                cache = new HashMap<>();
                loaderToCache.put(loader, cache);
            }
            
             * This mapping will remain valid for the duration of this
             * method, without further synchronization, because the mapping
             * will only be removed if the class loader becomes unreachable.
             
        }

        
         * Look up the list of interfaces in the proxy class cache using
         * the key.  This lookup will result in one of three possible
         * kinds of values:
         *     null, if there is currently no proxy class for the list of
         *         interfaces in the class loader,
         *     the pendingGenerationMarker object, if a proxy class for the
         *         list of interfaces is currently being generated,
         *     or a weak reference to a Class object, if a proxy class for
         *         the list of interfaces has already been generated.
         
        synchronized (cache) {
            
             * Note that we need not worry about reaping the cache for
             * entries with cleared weak references because if a proxy class
             * has been garbage collected, its class loader will have been
             * garbage collected as well, so the entire cache will be reaped
             * from the loaderToCache map.
             
            do {
                Object value = cache.get(key);
                if (value instanceof Reference) {
                    proxyClass = (Class<?>) ((Reference) value).get();
                }
                if (proxyClass != null) {
                    // proxy class already generated: return it
                    return proxyClass;
                } else if (value == pendingGenerationMarker) {
                    // proxy class being generated: wait for it
                    try {
                        cache.wait();
                    } catch (InterruptedException e) {
                        
                         * The class generation that we are waiting for should
                         * take a small, bounded time, so we can safely ignore
                         * thread interrupts here.
                         
                    }
                    continue;
                } else {
                    
                     * No proxy class for this list of interfaces has been
                     * generated or is being generated, so we will go and
                     * generate it now.  Mark it as pending generation.
                     
                    cache.put(key, pendingGenerationMarker);
                    break;
                }
            } while (true);
        }

        try {
            String proxyPkg = null;     // package to define proxy class in

            
             * Record the package of a non-public proxy interface so that the
             * proxy class will be defined in the same package.  Verify that
             * all non-public proxy interfaces are in the same package.
             
            for (int i = 0; i < interfaces.length; i++) {
                int flags = interfaces[i].getModifiers();
                if (!Modifier.isPublic(flags)) {
                    String name = interfaces[i].getName();
                    int n = name.lastIndexOf('.');
                    String pkg = ((n == -1) ? "" : name.substring(0, n + 1));
                    if (proxyPkg == null) {
                        proxyPkg = pkg;
                    } else if (!pkg.equals(proxyPkg)) {
                        throw new IllegalArgumentException(
                            "non-public interfaces from different packages");
                    }
                }
            }

            if (proxyPkg == null) {
                // if no non-public proxy interfaces, use com.sun.proxy package
                proxyPkg = ReflectUtil.PROXY_PACKAGE + ".";
            }

            {
                
                 * Choose a name for the proxy class to generate.
                 
                long num;
                synchronized (nextUniqueNumberLock) {
                    num = nextUniqueNumber++;
                }
                String proxyName = proxyPkg + proxyClassNamePrefix + num;
                
                 * Verify that the class loader hasn't already
                 * defined a class with the chosen name.
                 

                
                 * Generate the specified proxy class.
                 
                // 此处为重点代码：动态生成代理对象，生成字节码文件（更多详细请自行跟进查阅）
                byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                    proxyName, interfaces);
                try {
                    // 根据代理类的字节码生成代理类的实例  
                    proxyClass = defineClass0(loader, proxyName,
                        proxyClassFile, 0, proxyClassFile.length);
                } catch (ClassFormatError e) {
                    
                     * A ClassFormatError here means that (barring bugs in the
                     * proxy class generation code) there was some other
                     * invalid aspect of the arguments supplied to the proxy
                     * class creation (such as virtual machine limitations
                     * exceeded).
                     
                    throw new IllegalArgumentException(e.toString());
                }
            }
            // add to set of all generated proxy classes, for isProxyClass
            proxyClasses.put(proxyClass, null);

        } finally {
            
             * We must clean up the "pending generation" state of the proxy
             * class cache entry somehow.  If a proxy class was successfully
             * generated, store it in the cache (with a weak reference);
             * otherwise, remove the reserved entry.  In all cases, notify
             * all waiters on reserved entries in this cache.
             
            synchronized (cache) {
                if (proxyClass != null) {
                    cache.put(key, new WeakReference<Class<?>>(proxyClass));
                } else {
                    cache.remove(key);
                }
                cache.notifyAll();
            }
        }
        return proxyClass;
    }*/
        
}
