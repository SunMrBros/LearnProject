package org.myproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class FirstTest {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress address=InetAddress.getLocalHost();
		System.out.println("getAddress()"+address.getAddress());
		byte[] bytes=address.getAddress();
		System.out.println(bytes.toString());
		for(byte i:bytes){
			System.out.println(i);
		}
		System.out.println("getHostAddress()"+address.getHostAddress());
		System.out.println("getHostName()"+address.getHostName());
//		System.out.println(""+address.getByte());
		BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			URL baidu=new URL("http://www.baidu.com");
			URL url=new URL(baidu,"/index.html");
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			
//			bw=new BufferedWriter(new FileWriter(new File("/Users/KangZheng/Documents/baidu.html")));
//			InputStream in=baidu.openStream();
//			InputStreamReader isr=new InputStreamReader(in,"utf-8");
//			br=new BufferedReader(isr);
//			String str=null;
//			while((str=br.readLine())!=null){
//				bw.write(str);
//			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
