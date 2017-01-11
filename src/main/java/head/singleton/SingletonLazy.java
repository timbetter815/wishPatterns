package head.singleton;

/**
 * DESC 延迟加载单例（即，当且仅当在单例对象需要的时候才生成单例）
 * @author ttx
 * @since 2016年2月11日 下午2:40:45
 */
public class SingletonLazy {
	private static SingletonLazy singletonLazy =  null;

	// 单例模式构造方法必须private私有化，才能禁止被多次new
	private SingletonLazy(){
	}

	// 该方法的错误在于，在多线程场景下，当singletonLazy == null为true时候，恰好线程切换到其他线程，就导致创建了多个单例对象
	public static SingletonLazy  getInstanceError1(){
		if(singletonLazy == null){
			return new SingletonLazy();
	}else{
		return singletonLazy;
		}
	}
	
	// 因此getInstanceError1方法不满足在多线程下面允许，那么直接将方法加锁即解决了该问题
	// 该方法的不足之处在于，一般单例场景会是多次调用，如果直接将整个方法全部用synchronized锁住，那么肯定性能效率会大大降低。那么有没有其他更好的方式解决呢？
	public static synchronized SingletonLazy  getInstanceWarn1(){
		if(singletonLazy == null){
			return new SingletonLazy();
	}else{
		return singletonLazy;
		}
	}
	
	/**
	 * DESC 单例中经典的双检  （但是此方式必须设置private static volatile SingletonLazy singletonLazy =  null;）
	 * ---- 1、此处设置singletonLazy变量为volatile，才能保证在jdk 1.5以后 双检单例能生效（具体解释见下述：关于双检对于jdk1.5后成立依据）
	 * 
	 * ---- DCL失效原因是：获得锁的线程正在执行构造函数的时候，
	 *      其他的线程执行到第一次检查if (singletonLazy == null)的时候，会返回false，
	 *      因为已经在执行构造函数了，就不是null,因此，会把没有构造完全的对象返回给线程使用。这是不安全的。
	 *
	 * 
	 *---- 关于双检对于jdk1.5后成立依据：
	 *   -- 0、JSR-133之前的旧Java内存模型中，虽然不允许volatile变量之间重排序，但旧的Java内存模型允许volatile变量与普通变量之间重排序。
	 *   -- 1、JSR-133专家组决定增强volatile的内存语义：严格限制编译器和处理器对volatile变量与普通变量的重排序，确保volatile的写-读和监视器的释放-获取一样，具有相同的内存语义。因此在jdk1.5之前双检不成立
	 *   -- 2、jdk1.5后volatile可以禁止jmm指令优化进行指令重排序，而new一个对象过程中，把变量指向已经完全创建好的对象是最后一步，既在指令没有重排序的情况下如果instance != null，这个对象就是已经完全创建好了。
	 *   -- 3、如果没有volatile修饰，helper = new Helper()这行代码在不同编译器上的行为是无法预知的：
	 *   -- 情况1：(1)helper = 给新的实体分配内存    (2)调用helper的构造函数来初始化helper的成员变量 （大部分编译器场景）
	 *   -- 情况2：(1)temp = 分配内存       (2)调用temp的构造函数     (3) helper = temp
	 *   ---使用情况1来说明问题：（即：一个对象new分为两个步骤，步骤一：分配内存，步骤二：为该对象赋值。如果线程恰好在刚刚分配内存即被切换出去，那么线程2看到的对象已经非null（其实还没来得及赋值））
	 *          线程A先进入，在执行到步骤1的时候被踢出了cpu。然后线程B进入，B看到的是helper 已经不是null了（内存已经分配），于是它开始放心地使用helper，
	 *          但这个是错误的，因为在这一时刻，helper的成员变量还都是缺省值，A还没 有来得及执行步骤2来完成helper的初始化。
	 *          
	 * 
	 * ---- 关于volatile解释：
	 *   -- volatile两个特性：
	 *   -- 1、可见性：对一个volatile变量的读，总是能看到（任意线程）对这个volatile变量最后的写入。
	 *   -- 2、并不具备完全原子性：对任意单个volatile变量的读/写具有原子性，但类似于volatile++这种复合操作不具有原子性。 因此不具备完全的原子性。
	 *   -- 3、volatile部分场景原子性：针对单个操作具备原子性，例如对于long、double如果没有volatile修饰，则多个线程操作时，有可能截取到一部分赋值（字节为单位的不完成赋值），
	 *        但是加了volatile修改则，能保证，多个线程对于多个字节的变量读写操作时原子性的。 但是volatile并不能保证，对于一个volatile修饰变量，复合操作原子性（ex：i++）
	 *   
	 *   
	 * ---- volatile 不保证 i++的原子性解释：（i++ 由读取-修改-写入 三个操作完成，不具体原子性）
	 *   -- 1、 volatile保证变量线程之间的可见性，变量的更新操作，能及时刷新到主存，通知到到其他线程。
	 *   -- 2、对于i++操作，由于字节码分为多个步骤：
	 *        第一步：getstatic 把i的值取到了操作栈顶,volatile保证了i值此时是正确的  
	 *        第二步：iadd（如果此时iadd被其他线程修改了值，则不保证变量的可见性）
	 *        第三步：putstatic 将第二步iadd完的值，刷新到主存（但是此时在第二步的时候，i的值已经被其他线程改变了）
	 *        
	 *        
	 * ---- 由于volatile只具备可见性（不具备原子性），所以使用volatile必须满足如下场景：
	 *   -- 1、对变量的写操作不依赖于当前值。
	 *   -- 2、该变量没有包含在具有其他变量的不变式中。
	 *
	 *
	 * ---- Java语言中有一个“先行发生”（happen—before）的规则，它是Java内存模型中定义的两项操作之间的偏序关系，
	 *      如果操作A先行发生于操作B，其意思就是说，在发生操作B之前，操作A产生的影响都能被操作B观察到，
	 *      “影响”包括修改了内存中共享变量的值、发送了消息、调用了方法等，它与时间上的先后发生基本没有太大关系。
     *
	 *
	 * ---- JDK1.5 采用新的内存模型JSR-133,JSR-133定义happen before原则：
	 *   -- 1、Each action in a thread happens before every action in that thread that comes later in the program's order.
     *         程序顺序规则：一个线程中的每个操作，happens- before 于该线程中的任意后续操作。
     *   -- 2、An unlock on a monitor happens before every subsequent lock on that same monitor.
     *         监视器锁规则：对一个监视器锁的解锁，happens- before 于随后对这个监视器锁的加锁。
     *         即：一次只有一个线程获取监视器，因此一个获取监视器的线程解锁之前执行的操作对后进入的线程的操作全部可见
     *   -- 3、A write to a volatile field happens before every subsequent read of that same volatile.
     *         volatile变量规则：对一个volatile域的写，happens- before 于任意后续对这个volatile域的读。
     *   -- 4、A call to start() on a thread happens before any actions in the started thread.
     *         Thread.start()的调用会happens-before于启动线程里面的动作。
     *   -- 5、All actions in a thread happen before any other thread successfully returns from a join() on that thread.
     *         Thread中的所有动作都happens-before于其他线程从Thread.join中成功返回。
     *   -- 6、传递性：如果A happens- before B，且B happens- before C，那么A happens- before C。
	 *        
	 *        
	 * @return
	 * @author ttx
	 * @since 2016年2月11日 下午3:14:59
	 */
	public static SingletonLazy getInstanceWarn2() {
		// DCL失效原因是:如果一个线程执行singletonLazy = new SingletonLazy();
		// 先分配内存，还没来的及赋真实值，那么就会将未初始化的对象返回回去，因此线程不安全
		// 因此需要将singletonLazy定义为volatile，保证对象构造原子性
		// PS：虽然synchronized保证了原子性，但是当线程a执行到3时候，另外的线程b可以执行到未加锁的1，从而导致了双检失效
		if (singletonLazy == null) {// 1
			synchronized (SingletonLazy.class) {
				if (singletonLazy == null) {// 2
					singletonLazy = new SingletonLazy();// 3
				}
			}

		}
		return singletonLazy;
	}
}
