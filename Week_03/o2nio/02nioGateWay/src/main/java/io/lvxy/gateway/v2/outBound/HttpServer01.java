package io.lvxy.gateway.v2.outBound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 单线程的socket程序
public class HttpServer01 {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                service(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static void service(Socket socket) {
        try {
//            Thread.sleep(5);
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            try {
                while ((line = bufferedReader.readLine()) != null && line.length()>0) {
                    System.out.println("recv : " + line);
                    if(line.contains("netty-test")){
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "netty-filter: "+line+"   hello,nio1";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (IOException e) { // | InterruptedException e) {
            e.printStackTrace();
        }
    }
}