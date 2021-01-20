package test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Hello from a thread!");
            TimeUnit.SECONDS.sleep(1);
         // 要连接的服务端IP地址和端口
    	    String host = "localhost"; 
    	    int port = 8801;
    	    // 与服务端建立连接
    	    Socket socket = new Socket(host, port);
    	    System.out.println("This is clent 1");
    	    // 建立连接后获得输出流
    	    OutputStream outputStream = socket.getOutputStream();
    	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    	    String message="你好  yiwangzhibujian  111  time="+ dateFormat.format(new Date());
    	    socket.getOutputStream().write(message.getBytes("UTF-8"));
    	    outputStream.close();
    	    socket.close();	   
            
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void main(String args[]) throws Exception {
	  for (int i = 0; i < 10; i++) {
		  Thread thread = new Thread(new Client());
	      thread.start();
	  }
	 
     System.out.println("In main method."); 
  }
}
