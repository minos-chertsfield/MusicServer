package com.minos.model;

import java.util.List;

import com.minos.bean.VideoInfo;

public interface VideoInfoMapper {
	//---------查询操作----------
	List<VideoInfo> queryAll();   //查询所有视频信息
	List<VideoInfo> queryByTitle(String title);    //根据名称查询视频信息
	List<VideoInfo> queryByArtist(String artist);  //根据艺术家查询视频信息
	VideoInfo queryById(long id);   //根据id查询视频信息
	List<VideoInfo> queryAllOrderByHot();   //根据热度对所有视频进行排序
	//---------插入操作----------
	boolean insertVideo(VideoInfo videoInfo);   //插入视频信息
	//---------删除操作----------
	boolean deleteVideoById(long id);   //根据id删除视频
	boolean deleteVideoByTitle(String title);   //根据名称删除视频
	boolean deleteVideoByArtist(String artist); //根据艺术家删除视频
	//---------修改操作-----------
	boolean updateVideo(VideoInfo videoInfo); //更新视频信息
}
