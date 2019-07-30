package com.minos.model;

import java.util.List;

import com.minos.bean.VideoInfo;

public interface VideoInfoMapper {
	//---------��ѯ����----------
	List<VideoInfo> queryAll();   //��ѯ������Ƶ��Ϣ
	List<VideoInfo> queryByTitle(String title);    //�������Ʋ�ѯ��Ƶ��Ϣ
	List<VideoInfo> queryByArtist(String artist);  //���������Ҳ�ѯ��Ƶ��Ϣ
	VideoInfo queryById(long id);   //����id��ѯ��Ƶ��Ϣ
	List<VideoInfo> queryAllOrderByHot();   //�����ȶȶ�������Ƶ��������
	//---------�������----------
	boolean insertVideo(VideoInfo videoInfo);   //������Ƶ��Ϣ
	//---------ɾ������----------
	boolean deleteVideoById(long id);   //����idɾ����Ƶ
	boolean deleteVideoByTitle(String title);   //��������ɾ����Ƶ
	boolean deleteVideoByArtist(String artist); //����������ɾ����Ƶ
	//---------�޸Ĳ���-----------
	boolean updateVideo(VideoInfo videoInfo); //������Ƶ��Ϣ
}
