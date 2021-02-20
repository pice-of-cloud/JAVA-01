#### 单例模式的实现方式一共有6中，自己使用过的也就只有DCL，以后可以试试枚举方式，优缺点认识不深刻，以后有机会继续补充。
##### 1.饿汉式单例，线程安全，
classloader 机制来保证初始化 instance 时只有一个线程
###### 优点：简单，无锁执行效率高
###### 缺点：内存浪费，因为初始化类的时候已经初始化实例。
```
/**
 * 饿汉式单例
 */
public class Singleton01 {
    private static Singleton01 instance = new Singleton01();
    private Singleton01(){}
    public static Singleton01 getInstance(){
        return instance;
    }
}

```
##### 2.懒汉模式单例
###### 优点：简单，使用时才加载，省内存。
###### 缺点：单线程使用，多线程下，线程不安全。
###### 代码：
```
/**
 * 懒汉式单例
 * 单线程使用，多线程下，线程不安全
 */
public class Singleton02 {
    private static Singleton02 instance;
    private Singleton02(){}
    public static Singleton02 getInstance(){
        if(instance == null){
            instance = new Singleton02();
        }
        return instance;
    }
}

```
##### 3.懒汉模式单例，加锁
###### 优点：线程安全。仅初始化一次，省空间。
###### 缺点：加锁后，线程安全，执行效率变低。
###### 代码：
```
/**
 *  懒汉式单例
 *  增加方法同步，线程安全
 */
public class Singleton03 {
    private static Singleton03 instance;
    private Singleton03(){}
    public static synchronized  Singleton03 getInstance(){
        if (instance == null){
            instance = new Singleton03();
        }
        return instance;
    }
}

```
##### 4.双重检查 DCL，即 double-checked locking
###### 优点：线程安全，性能高。
###### 缺点：难实现？难理解？自己研究多线程当时候研究过。
###### 代码：
```
/**
 * 双重检查
 * 增加volatile
 * 线程安全
 */
public class Singleton04 {
    private static volatile Singleton04 instance ;
    private Singleton04(){}
    public static Singleton04 getInstance(){
        if(instance == null){
            synchronized (Singleton04.class){
                if(instance == null){
                    instance = new Singleton04();
                }
            }
        }
        return instance;
    }
}

```
##### 5.静态内部类
classloader 机制来保证初始化 instance 时只有一个线程；</br>
实例是在内部类中，加载类，但是没有调用内部类不会初始化实例
###### 优点：简单，线程安全
###### 缺点：？
###### 代码：
```
/**
 * 静态内部类
 */
public class Singleton05 {
    private static class SinglentonInner {
        private static final Singleton05 INSTANCE = new Singleton05();
    }
    private Singleton05(){}
    public static final Singleton05 getInstance(){
        return SinglentonInner.INSTANCE;
    }
}
  ```
##### 6.枚举
###### 优点：简单，线程安全
###### 缺点：难理解？，枚举其实工作中有用，但是用它做单例没用过，看了enum源码，决定以后可以用。
###### 代码：
```
/**
 * 枚举单例
 * since  JDK1.5
 * 源码标注 implicitly declared methods synthesized by the compiler
 */
public enum Singleton06 {
    INSTANCE;
    //可以省略
    public static Singleton06 getInstance(){
        return INSTANCE;
    }
}

```


