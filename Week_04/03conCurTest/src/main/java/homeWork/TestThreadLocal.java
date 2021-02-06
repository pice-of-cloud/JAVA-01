package homeWork;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class TestThreadLocal {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return sum();
        }
    };

    public ThreadLocal<Integer> getThreadLocal() {
        return seqNum;
    }
    public int result = 0;

    public static void main(String[] args) {
        
        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法


        TestThreadLocal threadLocalMain = new TestThreadLocal();
        TestWork testWork = new TestWork(threadLocalMain);
        testWork.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = testWork.getSum();//这是得到的返回值
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为3："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        
        // 然后退出main线程
    }
    
    private static int sum() {
        return fibo(36);
    }
    
    private static int fibo(int a) {
        if ( a < 2) 
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

}

class TestWork extends Thread{

    private TestThreadLocal testThreadLocal;

    public TestWork(TestThreadLocal threadLocal09){ this.testThreadLocal = testThreadLocal;}
    private int tempSum = 0;
    public void run() {
        int temp = testThreadLocal.getThreadLocal().get();
        tempSum = temp;
        testThreadLocal.getThreadLocal().remove();
    }

    public int getSum(){return this.tempSum;}

}
