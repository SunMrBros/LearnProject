package org.myproject.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	Socket socket=null;
	public ServerThread(Socket socket){
		this.socket=socket;
	}
	public void run(){
		//获取客户端的发送的信息 
		InputStream in=null;
		try {
			in = socket.getInputStream();
			
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
			socket.shutdownOutput();
			isr.close();
			pw.close();
			socket.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
