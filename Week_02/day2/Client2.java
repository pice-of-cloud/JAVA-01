package test;

import java.io.OutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client2 {
	  public static void main(String args[]) throws Exception {
	    // 要连接的服务端IP地址和端口
	    String host = "localhost"; 
	    int port = 8801;
	    // 与服务端建立连接
	    Socket socket = new Socket(host, port);
	    System.out.println("This is clent 2,I'm the first");
	    // 建立连接后获得输出流
	    OutputStream outputStream = socket.getOutputStream();
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	    String message="你好  I'm the first 2222222222222222 time="+dateFormat.format(new Date());
	    socket.getOutputStream().write(message.getBytes("UTF-8"));
	    outputStream.close();
	    socket.close();
	  }
	
}
