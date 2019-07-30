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
	
	
	public List<VideoInfo> queryAll() {     //查询所有视频信息
		try (SqlSession session = sqlSessionFactory.openSession()) {
            VideoInfoMapper mapper = session.getMapper(VideoInfoMapper.class);
            return mapper.queryAll();
    	}
	}
	
	public List<VideoInfo> queryAllOrderByHot() {     //根据热度排序
		try (SqlSession session = sqlSessionFactory.openSession()) {
            VideoInfoMapper mapper = session.getMapper(VideoInfoMapper.class);
            return mapper.queryAllOrderByHot();
    	}
	}
	
	public List<VideoInfo> queryByArtist(String artist) {    //根据艺术家查询视频
		try (SqlSession session = sqlSessionFactory.openSession()) {
            VideoInfoMapper mapper = session.getMapper(VideoInfoMapper.class);
            return mapper.queryByArtist(artist);
    	}
	}
	
	public List<VideoInfo> queryByTitle(String title) {   //根据名称查询视频
		try (SqlSession session = sqlSessionFactory.openSession()) {
            VideoInfoMapper mapper = session.getMapper(VideoInfoMapper.class);
            return mapper.queryByTitle(title);
    	}
	}
}
