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
			
			System.out.println(dictDef.getClassName());
			
			resultEntity.setMsg("查询成功");
			resultEntity.setSuccess(true);
			resultEntity.setObject(user);
			GsonTools.writeJsonObj(response, resultEntity);
	    }catch(Exception e){
	    	e.printStackTrace();
	    	
	    }
	
	    
	}
	

}
