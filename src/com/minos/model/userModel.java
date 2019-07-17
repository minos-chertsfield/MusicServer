package com.minos.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.minos.bean.User;


public class userModel {   //注册数据类
	
	
	private SqlSessionFactory sqlSessionFactory;

    public userModel() {
        String res = "mybatis-config.xml";   //配置文件
        InputStream is = null;    
        try {
            is = Resources.getResourceAsStream(res);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }
    
    public List<User> queryAll() {        //查询所有用户
    	try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.queryAll();
    	}
    }

    public User queryByUid(String uid) {   //根据用户名查询用户
    	
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.queryByUid(uid);
        }
    }
    
	public User queryByMac(String mac) {   //根据设备硬件地址查询用户
	    	
	        try (SqlSession session = sqlSessionFactory.openSession()) {
	            UserMapper mapper = session.getMapper(UserMapper.class);
	            return mapper.queryByMac(mac);
	        }
	    }
	
	public User queryByEmail(String email) {   //根据电子邮箱查询用户
    	
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.queryByEmail(email);
        }
    }
	
	public User queryByMobile(String mobile) {   //根据手机号码查询用户
    	
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.queryByMobile(mobile);
        }
    }
	
	public boolean insertUser(User user) {       //插入用户数据
		boolean flag = true;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			UserMapper mapper = session.getMapper(UserMapper.class);
			mapper.insertUser(user);
			session.commit();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
}
