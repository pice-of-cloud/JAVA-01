package io.lvxy.singleton;

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
