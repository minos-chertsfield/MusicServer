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


public class userModel {   //ע��������
	
	
	private SqlSessionFactory sqlSessionFactory;

    public userModel() {
        String res = "mybatis-config.xml";   //�����ļ�
        InputStream is = null;    
        try {
            is = Resources.getResourceAsStream(res);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }
    
    public List<User> queryAll() {        //��ѯ�����û�
    	try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.queryAll();
    	}
    }

    public User queryByUid(String uid) {   //�����û�����ѯ�û�
    	
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.queryByUid(uid);
        }
    }
    
	public User queryByMac(String mac) {   //�����豸Ӳ����ַ��ѯ�û�
	    	
	        try (SqlSession session = sqlSessionFactory.openSession()) {
	            UserMapper mapper = session.getMapper(UserMapper.class);
	            return mapper.queryByMac(mac);
	        }
	    }
	
	public User queryByEmail(String email) {   //���ݵ��������ѯ�û�
    	
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.queryByEmail(email);
        }
    }
	
	public User queryByMobile(String mobile) {   //�����ֻ������ѯ�û�
    	
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            return mapper.queryByMobile(mobile);
        }
    }
	
	public boolean insertUser(User user) {       //�����û�����
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
