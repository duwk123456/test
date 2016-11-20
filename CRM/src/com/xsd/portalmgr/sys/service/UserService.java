
package com.xsd.portalmgr.sys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xsd.portalmgr.sys.dao.UserDao;
import com.xsd.portalmgr.sys.entity.UserInfo;

/**
 * @author duwk
 * @date： 日期：2016-11-18 时间：上午8:56:35
 */

@Service("userService")
public class UserService {

	@Resource
	private UserDao  userDao;
	
	public List<UserInfo> findUser(){
		
		return userDao.findAllUser();

		
	}
	
}
