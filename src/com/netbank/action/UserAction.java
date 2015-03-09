package com.netbank.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;


import com.netbank.biz.UserBiz;
import com.netbank.entity.Account;
import com.netbank.entity.Password;
import com.netbank.entity.Personinfo;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements RequestAware,SessionAware{

	//定义通过@Resource注解注入的属性userBiz,可省略set方法
	@Resource private UserBiz userBiz;
	
	Map<String, Object> request;
	Map<String, Object> session;
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	private Account account;
	private Personinfo personinfo;
	private Password pwd;
	
	//表单验证
	public void validateLogin(){
		System.out.println("username  :  " + account.getUsername());
		Account a = userBiz.getAccount(account.getUsername());
		if (a == null) {
			this.addFieldError("username", "用户名不存在！");
		} else {
			if (!account.getPassword().equals(a.getPassword())) {
				this.addFieldError("password", "密码不正确");
			}
		}
		account = a;
	}
	
	//登陆请求
	public String login(){
		personinfo = (Personinfo)account.getPersoninfos().iterator().next();
		
		session.put("user", account);
		session.put("personinfo", personinfo);
		
		return SUCCESS;
	}
	
	//修改密码页面验证
	public void validateChangepwd(){
		account = (Account)session.get("user");
		if(!pwd.getOldpwd().equals(account.getPassword())){
			this.addFieldError("pwd.oldpwd", "密码不正确");
		}
		if(!pwd.getNewpwd().equals(pwd.getConfirmpwd())){
			this.addFieldError("pwd.confirmpwd", "两次密码不一致");
		}
	}
	
	//执行修改密码
	public String changepwd(){
		account.setPassword(pwd.getNewpwd());
		if(userBiz.modifyAccount(account)){
			session.put("user", account);
			request.put("message", "密码修改成功");
			return "message";
		}
		request.put("message", "密码修改失败！");
		return "message";
	}
	
	//登出
	public String logout(){
		
		if (session.get("user")!= null) {
			session.remove("user");
			System.out.println("user removed!");
		}
			
		return "index";
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Personinfo getPersoninfo() {
		return personinfo;
	}

	public void setPersoninfo(Personinfo personinfo) {
		this.personinfo = personinfo;
	}

	public Password getPwd() {
		return pwd;
	}

	public void setPwd(Password pwd) {
		this.pwd = pwd;
	}
	

}
