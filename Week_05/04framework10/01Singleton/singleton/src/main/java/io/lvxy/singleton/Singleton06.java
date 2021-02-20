package io.lvxy.singleton;

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
