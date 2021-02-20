package io.lvxy.singleton;

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
