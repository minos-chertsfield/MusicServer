package com.minos.model;

import java.util.List;



import com.minos.bean.User;


public interface UserMapper {      //用户的映射接口
	//------------查询操作------------
	List<User> queryAll();        //查询所有用户
	User queryByMac(String mac);    //根据硬件设备地址查询用户
	User queryByUid(String uid);    //根据用户名查询用户
	User queryByEmail(String email);    //根据电子邮箱查询用户
	User queryByMobile(String mobile);   //根据手机号码查询用户
	//------------插入操作------------
	boolean insertUser(User user);    //插入用户
	//------------删除操作------------
	boolean deleteUserByUid(String uid);   //根据用户名删除用户
	boolean deleteUserByMac(String mac);   //根据设备硬件地址删除用户
	boolean deleteUserByEmail(String email);   //根据用户电子邮箱删除用户
	boolean deleteUserByMobile(String mobile);   //根据用户手机号码删除用户
	//------------修改操作------------
	boolean updateUser(User user);   //更新用户
}
