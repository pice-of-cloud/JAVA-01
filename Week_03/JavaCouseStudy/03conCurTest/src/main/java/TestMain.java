public class TestMain {
   public static void main(String[] args){

       if(args == null || args.length == 0){
           System.out.println("args is null");
       }else {
           for (int i = 0; i < args.length; i++) {
               System.out.println("this is args[] ====="+args[i]);
           }
       }
   }

}
