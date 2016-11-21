package com.xsd.portalmgr.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.xsd.portalmgr.common.BaseController;
import com.xsd.portalmgr.common.entity.ResultEntity;
import com.xsd.portalmgr.sys.entity.DictDef;
import com.xsd.portalmgr.sys.entity.UserInfo;
import com.xsd.portalmgr.sys.service.UserService;
import com.xsd.portalmgr.util.DictDefUtil;
import com.xsd.portalmgr.util.GsonTools;



/**
 * 
 * @author duwk
 * @date： 日期：2016-11-17 时间：下午4:35:39
 */

@Controller
@RequestMapping("/system")
public class SystemController extends BaseController {
	private static Logger log = Logger.getLogger(SystemController.class);
	
	@Autowired
	private UserService userService;
	
	
	
	
	
	
	@RequestMapping(value="/hello")
	public void  helloWorld(HttpServletRequest request,HttpServletResponse response){
	    ResultEntity resultEntity = new ResultEntity();
	    try{
	    	System.out.println("hello");
			List<UserInfo> user  = userService.findUser();
			DictDef dictDef=	DictDefUtil.getDictDefEntity("1001", "100101","1");
			resultEntity.setMsg("查询成功");
			resultEntity.setSuccess(true);
			resultEntity.setObject(user);
			GsonTools.writeJsonObj(response, resultEntity);
	    }catch(Exception e){
	    	e.printStackTrace();	
	    }
	
	    
	}
	
	
	
	
	@RequestMapping(value="/login")
	public void  login(HttpServletRequest request,HttpServletResponse response,UserInfo userInfo){
	    ResultEntity resultEntity = new ResultEntity();
	    try{
			int code =userService.loginSys(request, userInfo);
			switch (code) {
			case 1:
				resultEntity.setProperty("code", code);
				resultEntity.setSuccess(true);
				resultEntity.setMsg("验证通过");
				break;			
		   case 2:
				resultEntity.setProperty("code", code);
				resultEntity.setSuccess(false);
				resultEntity.setMsg("验证码错误,请重新输入");
				break;
		   case 3:
				resultEntity.setProperty("code", code);
				resultEntity.setSuccess(false);
				resultEntity.setMsg("户名或密码不正确，请重新输入");
				break;
		   case 4:
				resultEntity.setProperty("code", code);
				resultEntity.setSuccess(false);
				resultEntity.setMsg("服务异常");
				break;
			default:
				break;
			}
	    }catch(Exception e){
	    	e.printStackTrace();
	    	resultEntity.setProperty("code", 4);
			resultEntity.setSuccess(false);
			resultEntity.setMsg("服务异常");
	    }
		GsonTools.writeJsonObj(response, resultEntity);
	    
	}
	
	
	
	@RequestMapping(value="/modifyPwd")
	public void  modifyPwd(HttpServletRequest request,HttpServletResponse response,UserInfo userInfo){
	    ResultEntity resultEntity = new ResultEntity();
	    try{
	    	
			int code =userService.modifyPwd(request, userInfo);
			switch (code) {
			 case 1:
				resultEntity.setProperty("code", code);
				resultEntity.setSuccess(true);
				resultEntity.setMsg("密码修改成功");
				break;	
		     case 2:
	    	    resultEntity.setProperty("code", code);
				resultEntity.setSuccess(false);
				resultEntity.setMsg("服务异常");
				break;
		     case 3:
				resultEntity.setProperty("code", code);
				resultEntity.setSuccess(false);
				resultEntity.setMsg("用户不存在");
				break;
		     case 4:
				resultEntity.setProperty("code", code);
				resultEntity.setSuccess(false);
				resultEntity.setMsg("原密码错误,请重新输入");
				break;

			 default:
				break;
			}
	    }catch(Exception e){
	    	e.printStackTrace();
	    	resultEntity.setProperty("code", 5);
			resultEntity.setSuccess(false);
			resultEntity.setMsg("服务异常");
	    }
		GsonTools.writeJsonObj(response, resultEntity);
	    
	}
	
	
	
	@RequestMapping(value="/regUser")
	public void  regUser(HttpServletRequest request,HttpServletResponse response,UserInfo userInfo){
	    ResultEntity resultEntity = new ResultEntity();
	    try{
	    	
			int code =userService.regUser(userInfo);
			switch (code) {
			 case 1:
				resultEntity.setProperty("code", code);
				resultEntity.setSuccess(true);
				resultEntity.setMsg("密码修改成功");
				break;	
		     case 2:
	    	    resultEntity.setProperty("code", code);
				resultEntity.setSuccess(false);
				resultEntity.setMsg("服务异常");
				break;
		     case 3:
				resultEntity.setProperty("code", code);
				resultEntity.setSuccess(false);
				resultEntity.setMsg("用户不存在");
				break;
		     case 4:
				resultEntity.setProperty("code", code);
				resultEntity.setSuccess(false);
				resultEntity.setMsg("原密码错误,请重新输入");
				break;

			 default:
				break;
			}
	    }catch(Exception e){
	    	e.printStackTrace();
	    	resultEntity.setProperty("code", 5);
			resultEntity.setSuccess(false);
			resultEntity.setMsg("服务异常");
	    }
		GsonTools.writeJsonObj(response, resultEntity);
	    
	}
	
	

}
