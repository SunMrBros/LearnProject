package org.myproject.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceClient {

	public static void main(String[] args) {
//创建服务器端Socket
		try {
			ServerSocket serverSocket =new ServerSocket(8888);
			//调用accept() 方法开始监听，等待客户端连接
			System.out.println("服务器已经启动，等待连接。。。");
			Socket socket=null;
			while(true){
				socket=serverSocket.accept();
				new ServerThread(socket).start();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
