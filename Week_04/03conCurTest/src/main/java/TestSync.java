import java.util.concurrent.TimeUnit;

public class TestSync {
    public void f() {
        // other operations should not be locked...
        System.out.println(Thread.currentThread().getName()
                + ":not synchronized in f()");
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()
                        + ":synchronized in f()---i="+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void g() {
        // other operations should not be locked...
        System.out.println(Thread.currentThread().getName()
                + ":not synchronized in g()");
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()
                        + ":synchronized in g()---i="+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void h() {
        // other operations should not be locked...
        System.out.println(Thread.currentThread().getName()
                + ":not synchronized in h()");
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()
                        + ":synchronized in h()---i="+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final TestSync rs = new TestSync();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                rs.f();
            }
        },"t1");
        t1.start();


       Thread t2 = new Thread(new Runnable() {
           @Override
           public void run() {
               rs.g();
           }
       },"t2");

        t2.start();
        rs.h();
    }
}