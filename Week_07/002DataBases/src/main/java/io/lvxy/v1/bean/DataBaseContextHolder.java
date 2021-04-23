package io.lvxy.v1.bean;

import java.util.concurrent.atomic.AtomicInteger;

public class DataBaseContextHolder {

    //区分主从数据源
    public enum DataBaseType {
        MASTER, SLAVE1, SLAVE2
    }
    //线程局部变量
    private static final ThreadLocal<DataBaseType> contextHolder = new ThreadLocal<DataBaseType>();
    private static final AtomicInteger counter = new AtomicInteger(-1);
    //往线程里边set数据类型
    public static void setDataBaseType(DataBaseType dataBaseType) {
        if(dataBaseType == null) throw new NullPointerException();
        contextHolder.set(dataBaseType);
    }

    //从容器中获取数据类型
    public static DataBaseType getDataBaseType(){
        if(contextHolder.get() == null){
            return DataBaseType.MASTER;
        }else{
            return contextHolder.get();
        }

    }

    public static void master() {
        setDataBaseType(DataBaseType.MASTER);
        System.out.println("切换到master");
    }
    public static void slave() {
        //  轮询
        int index = counter.getAndIncrement() % 2;
        if (counter.get() > 9999) {
            counter.set(-1);
        }
        if (index == 0) {
            setDataBaseType(DataBaseType.SLAVE1);
            System.out.println("切换到slave1");
        }else {
            setDataBaseType(DataBaseType.SLAVE2);
            System.out.println("切换到slave2");
        }
    }
    //清空容器中的数据类型
    public static void clearDataBaseType(){
        contextHolder.remove();
    }

}
