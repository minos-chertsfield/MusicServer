package com.minos.model;

import java.util.List;



import com.minos.bean.User;


public interface UserMapper {      //�û���ӳ��ӿ�
	//------------��ѯ����------------
	List<User> queryAll();        //��ѯ�����û�
	User queryByMac(String mac);    //����Ӳ���豸��ַ��ѯ�û�
	User queryByUid(String uid);    //�����û�����ѯ�û�
	User queryByEmail(String email);    //���ݵ��������ѯ�û�
	User queryByMobile(String mobile);   //�����ֻ������ѯ�û�
	//------------�������------------
	boolean insertUser(User user);    //�����û�
	//------------ɾ������------------
	boolean deleteUserByUid(String uid);   //�����û���ɾ���û�
	boolean deleteUserByMac(String mac);   //�����豸Ӳ����ַɾ���û�
	boolean deleteUserByEmail(String email);   //�����û���������ɾ���û�
	boolean deleteUserByMobile(String mobile);   //�����û��ֻ�����ɾ���û�
	//------------�޸Ĳ���------------
	boolean updateUser(User user);   //�����û�
}
