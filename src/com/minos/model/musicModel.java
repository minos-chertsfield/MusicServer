package com.minos.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.minos.bean.MusicInfo;

public class musicModel {
	
	private SqlSessionFactory sqlSessionFactory;

	public musicModel() {
		String res = "mybatis-config.xml";   //≈‰÷√Œƒº˛
        InputStream is = null;    
        try {
            is = Resources.getResourceAsStream(res);   
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
	
	public List<MusicInfo> queryAll() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
            MusicInfoMapper mapper = session.getMapper(MusicInfoMapper.class);
            return mapper.queryAll();
    	}
	}
	
	public List<MusicInfo> queryByTitle(String title) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
            MusicInfoMapper mapper = session.getMapper(MusicInfoMapper.class);
            return mapper.queryByTitle(title);
    	}
	}
	
	public List<MusicInfo> queryByArtist(String artist) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
            MusicInfoMapper mapper = session.getMapper(MusicInfoMapper.class);
            return mapper.queryByArtist(artist);
    	}
	}
	
	public MusicInfo queryById(long id) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
            MusicInfoMapper mapper = session.getMapper(MusicInfoMapper.class);
            return mapper.queryById(id);
    	}
	}
	
	public List<MusicInfo> queryByAlbum(String album) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
            MusicInfoMapper mapper = session.getMapper(MusicInfoMapper.class);
            return mapper.queryByAlbum(album);
    	}
	}
	
	public boolean insertMusic(MusicInfo musicInfo) {
		boolean flag = true;
		try (SqlSession session = sqlSessionFactory.openSession()) {
            MusicInfoMapper mapper = session.getMapper(MusicInfoMapper.class);
            mapper.insertMusic(musicInfo);
            session.commit();
    	} catch (Exception e) {
    		flag = false;
		}
		return flag;
	}
	
	
	
	
	public boolean updateMusic(MusicInfo musicInfo) {
		boolean flag = true;
		try (SqlSession session = sqlSessionFactory.openSession()) {
            MusicInfoMapper mapper = session.getMapper(MusicInfoMapper.class);
            mapper.updateMusic(musicInfo);
            session.commit();
    	} catch (Exception e) {
    		flag = false;
		}
		return flag;		
	}
	
}
