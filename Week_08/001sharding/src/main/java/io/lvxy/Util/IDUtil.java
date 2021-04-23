package io.lvxy.Util;


import io.lvxy.config.SnowflakeIdWorker;

public class IDUtil {
    /**
     * 随机id生成，使用雪花算法
     */
    public static long getRandomId() {
        SnowflakeIdWorker sf = new SnowflakeIdWorker();
        long id = sf.nextId();
        return id;
    }
}