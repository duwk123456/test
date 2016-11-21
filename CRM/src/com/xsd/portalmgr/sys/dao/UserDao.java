package com.xsd.portalmgr.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xsd.portalmgr.sys.entity.UserInfo;

/**
 * @author duwk
 * @date： 日期：2016-11-18 时间：上午8:57:05
 */
@Repository("userDao")
public interface UserDao {
	
	 List<UserInfo> findAllUser();

	/**
	 *@author duwk 
	 *@date  2016-11-21 
	 * @param userInfo
	 * @return
	 */
	UserInfo findUser(UserInfo userInfo);

	/**
	 *@author duwk 
	 *@date  2016-11-21 
	 * @param existUser
	 */
	void updateUser(UserInfo existUser);

	/**
	 *@author duwk 
	 *@date  2016-11-21 
	 * @param userInfo
	 */
	void addUser(UserInfo userInfo);
	

}
