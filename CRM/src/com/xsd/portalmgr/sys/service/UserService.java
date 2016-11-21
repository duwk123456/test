
package com.xsd.portalmgr.sys.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsd.portalmgr.common.ClientVarConst;
import com.xsd.portalmgr.sys.controller.SystemController;
import com.xsd.portalmgr.sys.dao.UserDao;
import com.xsd.portalmgr.sys.entity.UserInfo;
import com.xsd.portalmgr.util.MD5Util;
import com.xsd.servlet.IdentityServlet;

/**
 * @author duwk
 * @date： 日期：2016-11-18 时间：上午8:56:35
 */

@Service("userService")
@Transactional(rollbackFor=Exception.class)
public class UserService {

	private static Logger log = Logger.getLogger(UserService.class);
	@Resource
	private UserDao  userDao;
	
	public List<UserInfo> findUser(){
		
		return userDao.findAllUser();

		
	}

	/**用户验证登陆
	 *@author duwk 
	 *@date  2016-11-21 
	 * @param request
	 * @param userInfo
	 */
	public int loginSys(HttpServletRequest request, UserInfo userInfo) {
		
		int code=1;//标识
		try{
		String vcode  = request.getParameter("vcode");
		String trueCode =(String) request.getSession().getAttribute(ClientVarConst.VALID_CODE_SESSION_KEY);
		log.info("vcode:"+vcode+" trueCode:"+trueCode);
		if(vcode.equalsIgnoreCase(trueCode)){
			log.info("验证码正确,进一步验证用户名密码");
			UserInfo existUser = userDao.findUser(userInfo);
			if(existUser!=null){
				 String pwd =MD5Util.MD5(userInfo.getUserName()+MD5Util.MD5(userInfo.getPassword()));
				 if(pwd.equals(existUser.getPassword())){
					 code=1;
					 log.info("验证通过");
					 request.getSession().setAttribute(ClientVarConst.SESSION_KEY,existUser);
				 }else{
					 code=3;
					 log.info("用户名或密码不正确，请重新输入");
				 }
			}else{
				code=3;
				log.info("用户名或密码不正确，请重新输入");
			}	
		}else{
			code=2;//标识验证码错误
		}
		}catch(Exception e){
			e.printStackTrace();
			code=4;
		}
		return code;
	}

	/**
	 *@author duwk 
	 *@date  2016-11-21 
	 * @param request
	 * @param userInfo
	 * @return
	 */
	public int modifyPwd(HttpServletRequest request, UserInfo userInfo) {
		
		int code=1;//标识
		String newPwd  = request.getParameter("newPwd");
		UserInfo existUser = userDao.findUser(userInfo);
		//step1: 判断参数
		if(StringUtils.isNotEmpty(newPwd)
				&&StringUtils.isNotEmpty(userInfo.getUserId())
				&&StringUtils.isNotEmpty(userInfo.getPassword())){
		//step2: 根据id 查找用户是否存在
		if(existUser!=null){
			 String pwd =MD5Util.MD5(userInfo.getUserName()+MD5Util.MD5(userInfo.getPassword()));
			 //step3: 验证原密码是否正确
			 if(pwd.equals(existUser.getPassword())){
				 String encodePwd =MD5Util.MD5(userInfo.getUserName()+MD5Util.MD5(newPwd));
				 existUser.setPassword(encodePwd);
				 userDao.updateUser(existUser);
				 code=1;
				 request.getSession().setAttribute(ClientVarConst.SESSION_KEY,existUser);
			}else{
				code=4;
				log.info("原密码错误,请重新输入");
			}
			
		}else{
			code=3;
			log.info("用户不存在");
		}
	}else{
		
		code=2;
		log.info("请求参数有误：newPwd:"+newPwd+" password:"+userInfo.getPassword()+" userId:"+userInfo.getUserId());
	}
	
		return code;
	}

	/**
	 *@author duwk 
	 *@date  2016-11-21 
	 * @param userInfo
	 * @return
	 */
	public int regUser(UserInfo userInfo) {
	
		int code=1;//标识
		//step1: 根据userName查找用户是否存在
		UserInfo existUser = userDao.findUser(userInfo);
		if(existUser==null){
			 String pwd =MD5Util.MD5(userInfo.getUserName()+MD5Util.MD5(userInfo.getPassword()));
			 userInfo.setPassword(pwd);
             userDao.addUser(userInfo);
             code=1;
		}else{
			code=3;
			log.info("用户名已存在");
		}
	
	
		return code;
	}
	
	
	
	
	
	
	
	
}
