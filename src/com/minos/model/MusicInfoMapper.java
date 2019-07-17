package com.minos.model;

import java.util.List;

import com.minos.bean.MusicInfo;;

public interface MusicInfoMapper {    //������Ϣ��ӳ��ӿ�
		//------------��ѯ����------------
		List<MusicInfo> queryAll();        //��ѯ����������Ϣ
		List<MusicInfo> queryByTitle(String title);    //�������Ʋ�ѯ������Ϣ
		List<MusicInfo> queryByArtist(String artist);    //���������Ҳ�ѯ������Ϣ
		MusicInfo queryById(long id);    //����id��ѯ������Ϣ
		List<MusicInfo> queryByAlbum(String album);   //�����ֻ������ѯ�û�
		//------------�������------------
		boolean insertMusic(MusicInfo musicInfo);    //����������Ϣ
		//------------ɾ������------------
		boolean deleteMusicById(long id);   //����idɾ������
		boolean deleteMusicByAlbum(String album);   //����ר��ɾ������
		boolean deleteMusicByTitle(String title);   //����������ɾ������
		boolean deleteUserByArtist(String artist);   //�����û��ֻ�����ɾ���û�
		//------------�޸Ĳ���------------
		boolean updateMusic(MusicInfo musicInfo);   //����������Ϣ
}
