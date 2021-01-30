public class TestMainThread {

    public static void main(String[] args){

      Thread.currentThread().getThreadGroup().getParent().list();
    }
}
