import java.util.concurrent.TimeUnit;

public class TestSync3 {
    private Object testSync2_1 = new Object();
    private Object testSync2_2 = new Object();

    public void f() {
        // other operations should not be locked...
        System.out.println(Thread.currentThread().getName()
                + ":not synchronized in f()");
        synchronized (testSync2_1) {
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
        synchronized (testSync2_2) {
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
        /*final TestSync3 testSync2 = new TestSync3();
        new Thread() {
            public void run() {
                testSync2.f();
            }
        }.start();
        new Thread() {
            public void run() {
                testSync2.g();
            }
        }.start();
         testSync2.h();*/

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