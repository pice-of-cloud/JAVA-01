package homeWork;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class TestCyclicBarrier {

    public static void main(String[] args) {
        
        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        int N = 2;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N);
        Writer writer1 = new Writer(cyclicBarrier,sum());
        Writer writer2 = new Writer(cyclicBarrier,sum());
        writer1.start();
        writer2.start();
        //int result = sum(); //这是得到的返回值
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+ writer1.getCount());
        System.out.println("异步计算结果为："+ writer2.getCount());
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
class Writer extends Thread{
    private CyclicBarrier cyclicBarrier;
    private int countW;
    public Writer(CyclicBarrier cyclicBarrier, int count) {
        this.cyclicBarrier = cyclicBarrier;
        this.countW = count;
    }

    @Override
    public void run() {
        System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
        try {
            Thread.sleep(100);      //以睡眠来模拟写入数据操作
            System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch(BrokenBarrierException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"所有线程写入完毕，继续处理其他任务...");
    }

    public int getCount(){
        return countW;
    }

}