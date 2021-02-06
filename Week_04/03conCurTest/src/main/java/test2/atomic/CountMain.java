package test2.atomic;

public class CountMain {
    public static void main(String[] args){
        Count count = new Count();
        SyncCount syncCount = new SyncCount();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        count.add();
                        syncCount.add();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("count sum = "+count.getNum());
        System.out.println("synCount sum = "+syncCount.getNum());

    }
}
