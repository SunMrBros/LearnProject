package org.myproject.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.myproject.po.User;


public class MybatisFirst {
	private static Logger logger=Logger.getLogger(MybatisFirst.class);
	
	private SqlSessionFactory sqlSessionFactory=null;
	
	@Before
	public void init(){
		String res="SqlMapConfig.xml";
		
		InputStream inputstream=null;
		try {
			inputstream = Resources.getResourceAsStream(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputstream);	
		
	}
	@Test
	public void findUserById(){
	
		logger.info(sqlSessionFactory);
		SqlSession session=sqlSessionFactory.openSession();
		User user=session.selectOne("test.findUserById", 1);
		System.out.println(user);
		session.close();
		
	}
	
	@Test
	public void testInsertUser(){
		
		User user=new User();
		user.setUsername("kangzheng");
		user.setAddress("beijing");
		user.setBirthday(new Date());
		user.setSex(1);
		SqlSession session=sqlSessionFactory.openSession();
		int resNum=session.insert("test.insertUser", user);
		session.commit();
		System.out.println(resNum);
		session.close();
	}
	
	@Test
	public void testFindUser(){
		SqlSession session=sqlSessionFactory.openSession();
		List<User> list=session.selectList("test.findUsers");
		for(User user:list){
			System.out.println(user);
		}
		session.close();
	}
	
	@Test 
	public void testFindUserbyName(){
		
		SqlSession session=sqlSessionFactory.openSession();
		List<User> list=session.selectList("test.findUserbyName","kang");
		for(User user:list){
			System.out.println(user);
		}
		session.close();
	}

}
