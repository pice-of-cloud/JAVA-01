package io.lvxy.singleton;

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
