package com.zhiyou100.tset;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLPermission;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zhiyou100.mapper.UserMapper;
import com.zhiyou100.model.User;

public class TestMyBatis {
	SqlSession sqlSession;
	
	@Before
	public void creatsqlSession() throws IOException {
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlSessionFactory.openSession(true);
	}
	@Test
	public void findUserById() throws IOException {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}
	@Test
	public void insertUser() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setAddress("万达");
		user.setBirthday(new Date(90,0,1));
		user.setId(11);
		user.setSex('男');
		user.setUsername("王二");
		userMapper.insertUser(user);
		System.out.println(user);
	}
	@Test
	public void updateUser() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(16);
		user.setAddress("万达22");
		user.setBirthday(new Date(99,0,1));
		user.setSex('男');
		user.setUsername("王二丫丫");
		userMapper.updateUser(user);
		System.out.println(user);
	}
	@Test
	public void deleteUserById() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUserById(22);
	}
	@Test
	public void findUserByHashMap() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		HashMap<String,Integer> hm = new HashMap<>();
		hm.put("idHM", 25);
		User user = userMapper.findUserByHashMap(hm);
		System.out.println(user);
	}
	@Test
	public void findUserByLikeName() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		 List<User> user = userMapper.findUserByLikeName("三");
		System.out.println(user);
	}
}
