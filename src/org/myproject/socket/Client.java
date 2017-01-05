package org.myproject.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args){
		//创建客户端Socket ，指定服务器端地址和端口
		try {
			Socket socket=new Socket("127.0.0.1",8888);
			//获取输出流，用来向服务器端发送信息
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			pw.write("用户名：admin");
			pw.flush();
			socket.shutdownOutput();
			
			InputStream in=socket.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			String str=null;
			while((str=br.readLine())!=null){
				System.out.println("我是客户端，服务器说："+str);
			}
			pw.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
