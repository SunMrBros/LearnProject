package org.myproject.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
/**
 * 原始JDBC连接数据库
 * @author KangZheng
 *
 */
public class Orgjdbc {
	
	private static Logger logger=Logger.getLogger(Orgjdbc.class);

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载Driver驱动类，将Driver实例注册到DriverManager中
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybase", "root", "admin");
			if(conn!=null){
				logger.info("数据库连接打开。。");
			}
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from items");
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString(2);
				System.out.println("ID:"+id+";name:"+name);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if (conn != null) {
					logger.info("数据库连接关闭。。");
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
