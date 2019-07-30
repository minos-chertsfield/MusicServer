package com.minos.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.minos.bean.VideoInfo;

public class videoModel {

	private SqlSessionFactory sqlSessionFactory;

	public videoModel() {
		String res = "mybatis-config.xml"; 
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(res);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
	
	
	public List<VideoInfo> queryAll() {     //��ѯ������Ƶ��Ϣ
		try (SqlSession session = sqlSessionFactory.openSession()) {
            VideoInfoMapper mapper = session.getMapper(VideoInfoMapper.class);
            return mapper.queryAll();
    	}
	}
	
	public List<VideoInfo> queryAllOrderByHot() {     //�����ȶ�����
		try (SqlSession session = sqlSessionFactory.openSession()) {
            VideoInfoMapper mapper = session.getMapper(VideoInfoMapper.class);
            return mapper.queryAllOrderByHot();
    	}
	}
	
	public List<VideoInfo> queryByArtist(String artist) {    //���������Ҳ�ѯ��Ƶ
		try (SqlSession session = sqlSessionFactory.openSession()) {
            VideoInfoMapper mapper = session.getMapper(VideoInfoMapper.class);
            return mapper.queryByArtist(artist);
    	}
	}
	
	public List<VideoInfo> queryByTitle(String title) {   //�������Ʋ�ѯ��Ƶ
		try (SqlSession session = sqlSessionFactory.openSession()) {
            VideoInfoMapper mapper = session.getMapper(VideoInfoMapper.class);
            return mapper.queryByTitle(title);
    	}
	}
}
