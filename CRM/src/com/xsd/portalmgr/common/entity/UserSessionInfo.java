package com.xsd.portalmgr.common.entity;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;

public class UserSessionInfo implements Serializable {

	private static final long serialVersionUID = -3054591104926661617L;
/*	*//**
	 * 用户id
	 *//*
	private String user_id;
	*//**
	 * String login_name ：登录名或工号
	 *//*
	private String login_name;
	*//**
	 * String user_name ：姓名
	 *//*
	private String user_name;
	*//**
	 * String home_prov : 归属省份
	 *//*
	private String home_prov;
	*//**
	 * String home_city ：归属地市
	 *//*
	private String home_city;
	*//**
	 * String home_county ：归属县市
	 *//*
	private String home_county;
	*//**
	 * String email ：电子邮箱
	 *//*
	private String email;
	*//**
	 * String organ_id ：归属机构id
	 *//*
	private String organ_id;
	*//**
	 * String organ_name ：机构名称
	 *//*
	private String organ_name;
	*//**
	 * String organ_level ：机构等级
	 *//*
	private String organ_level;
	*//**
	 * String organ_type ：机构类别
	 *//*
	private String organ_type;
	*//**
	 * String status ：状态
	 *//*
	private String status;
	*//**
	 * Resource[] res_list ：资源列表,存放着所有资源信息
	 *//*
 	private List<SmResource> res_list;
	*//**
	 * String password : 密码
	 *//*
	private String password;
	*//**
	 * String tel : 电话
	 *//*
	private String tel;
	*//**
	 * SmRole[] role_list : 用户所属角色列表,存放角色信息
	 *//*
//	private List<SmRole> role_list;
	*//**
	 * 所属角色级别 多个时为级别最高
	 *//*
	private String role_level;
	
	*//**
	 * String login_time : 登录时间
	 *//*
	private String login_time;
	
	*//**
	 * 企业id
	 *//*
	private String ecId;
	
	*//**
	 * 顶层机构id
	 *//*
	private String root_organ_id;
    //添加ecName
    private String ecName;
    private String picture;
    
    //审核状态
    private String audit_status;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEcName() {
        return ecName;
    }

    public void setEcName(String ecName) {
        this.ecName = ecName;
    }

    public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getHome_prov() {
		return home_prov;
	}

	public void setHome_prov(String home_prov) {
		this.home_prov = home_prov;
	}

	public String getHome_city() {
		return home_city;
	}

	public void setHome_city(String home_city) {
		this.home_city = home_city;
	}

	public String getHome_county() {
		return home_county;
	}

	public void setHome_county(String home_county) {
		this.home_county = home_county;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrgan_id() {
		return organ_id;
	}

	public void setOrgan_id(String organ_id) {
		this.organ_id = organ_id;
	}

	public String getOrgan_name() {
		return organ_name;
	}

	public void setOrgan_name(String organ_name) {
		this.organ_name = organ_name;
	}

	public String getOrgan_level() {
		return organ_level;
	}

	public void setOrgan_level(String organ_level) {
		this.organ_level = organ_level;
	}

	public String getOrgan_type() {
		return organ_type;
	}

	public void setOrgan_type(String organ_type) {
		this.organ_type = organ_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<SmResource> getRes_list() {
		return res_list;
	}

	public void setRes_list(List<SmResource> res_list) {
		this.res_list = res_list;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRole_level() {
		return role_level;
	}

	public void setRole_level(String role_level) {
		this.role_level = role_level;
	}

	public String getLogin_time() {
		return login_time;
	}

	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}

	public String getRoot_organ_id() {
		return root_organ_id;
	}

	public void setRoot_organ_id(String root_organ_id) {
		this.root_organ_id = root_organ_id;
	}

	public String getEcId() {
		return ecId;
	}

	public void setEcId(String ecId) {
		this.ecId = ecId;
	}

	*//**
	 * @return the audit_status
	 *//*
	public String getAudit_status() {
		return audit_status;
	}

	*//**
	 * @param audit_status the audit_status to set
	 *//*
	public void setAudit_status(String audit_status) {
		this.audit_status = audit_status;
	}
	*/

	
}
