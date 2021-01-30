public class TestThreadJoin {

    public static void main(String[] args) {
        //Thread.currentThread().getThreadGroup().list();
        Object obj = new Object();
        MyThread myThread1 = new MyThread("myThread1---");
        myThread1.setObj(obj);
        myThread1.start();

       // Thread.currentThread().getThreadGroup().list();
        synchronized (obj){
            for (int i = 0; i < 30; i++) {

                if(i == 10){
                    try {
                        myThread1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("this is main thhread=="+i);
            }
            Thread.currentThread().getThreadGroup().list();
        }
    }

}
 class MyThread extends Thread{
    private String name;
    private Object obj;

    public MyThread(String name){
        this.name = name;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj){
            for (int i = 0; i < 50; i++) {
                System.out.println("this is TastRunnable---name="+i);

            }
            Thread.currentThread().getThreadGroup().list();
        }
    }
}

