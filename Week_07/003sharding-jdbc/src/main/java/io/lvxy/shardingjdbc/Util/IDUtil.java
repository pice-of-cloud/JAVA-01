package io.lvxy.shardingjdbc.Util;

import io.lvxy.shardingjdbc.config.SnowflakeIdWorker;

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