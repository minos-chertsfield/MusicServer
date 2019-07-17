package com.minos.model;

import java.util.List;

import com.minos.bean.MusicInfo;;

public interface MusicInfoMapper {    //音乐信息的映射接口
		//------------查询操作------------
		List<MusicInfo> queryAll();        //查询所有音乐信息
		List<MusicInfo> queryByTitle(String title);    //根据名称查询音乐信息
		List<MusicInfo> queryByArtist(String artist);    //根据艺术家查询音乐信息
		MusicInfo queryById(long id);    //根据id查询音乐信息
		List<MusicInfo> queryByAlbum(String album);   //根据手机号码查询用户
		//------------插入操作------------
		boolean insertMusic(MusicInfo musicInfo);    //插入音乐信息
		//------------删除操作------------
		boolean deleteMusicById(long id);   //根据id删除音乐
		boolean deleteMusicByAlbum(String album);   //根据专辑删除音乐
		boolean deleteMusicByTitle(String title);   //根据音乐名删除音乐
		boolean deleteUserByArtist(String artist);   //根据用户手机号码删除用户
		//------------修改操作------------
		boolean updateMusic(MusicInfo musicInfo);   //更新音乐信息
}
