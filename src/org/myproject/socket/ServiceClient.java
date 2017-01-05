package org.myproject.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceClient {

	public static void main(String[] args) {
//创建服务器端Socket
		try {
			ServerSocket serverSocket =new ServerSocket(8888);
			//调用accept() 方法开始监听，等待客户端连接
			System.out.println("服务器已经启动，等待连接。。。");
			Socket socket=serverSocket.accept();
			
			//获取客户端的发送的信息 
			InputStream in=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(in);
			BufferedReader br=new BufferedReader(isr);//为输入了添加缓冲
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println("我是服务器，客户端说："+info);
			}
			socket.shutdownInput();
			
			//获取输出流响应客户端请求
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			pw.write("欢迎您！");
			pw.flush();
			isr.close();
			pw.close();
			socket.close();
			serverSocket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
