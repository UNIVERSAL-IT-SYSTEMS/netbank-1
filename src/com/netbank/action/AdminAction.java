package com.netbank.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.netbank.biz.PersoninfoBiz;
import com.netbank.biz.UserBiz;
import com.netbank.dao.UserDao;
import com.netbank.entity.Account;
import com.netbank.entity.Admin;
import com.netbank.entity.Password;
import com.netbank.entity.Personinfo;
import com.netbank.entity.Status;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements RequestAware,SessionAware{

	@Resource private UserBiz userBiz;
	
	@Resource private PersoninfoBiz personinfoBiz;
	
	Map<String, Object> request;
	Map<String, Object> session;
	
	private Admin admin;
	private Account account;
	
	private Personinfo personinfo;
	private Password pwd;
	private int id;
	private Status status;
	public void setId(int id){
		this.id = id;
	}
	
	public void validateLogin(){
		Admin a = userBiz.getAdmin(admin.getUsername());
		if(a == null){
			this.addFieldError("username", "用户不存在");
		}else {
			if (!admin.getPwd().equals(a.getPwd())) {
				this.addFieldError("password", "密码不存在");
			}
			admin = a;
		}
	}
	
	public String login(){
		if (admin != null) {
			session.put("admin", admin);
			return "success";
		}
		return "login";
	}
	
    public String logout(){
		
		if (session.get("admin")!= null) {
			session.remove("admin");
			System.out.println("admin removed!");
		}
			
		return "index";
	}
	
	public String listUsers(){
		List users = personinfoBiz.searchPersoninfo(status);
		System.out.println("status.id =  "+status.getId());
		request.put("users", users);
		return "users";
	}
	
	public String search(){
		List users = personinfoBiz.searchPersoninfo(personinfo);
		request.put("users", users);
		return "users";
	}
	
	public String enabled(){
		userBiz.enabled(id);
		return "list";
	}
	
	public String locking(){
		userBiz.locking(id);
		System.out.println("id : "+id);
		return "list";
	}
	
	public String del(){
		userBiz.delAccount(id);
		return "list";
	}
	
	public void validateKaihu(){
		if (userBiz.getAccount(account.getUsername())!=null) {
			request.put("message", "用户名已存在");
		}
		
		List list = personinfoBiz.searchPersoninfo(personinfo);
		if (list.size() > 0) {
			this.addFieldError("personinfo.cardid", "一张身份证只能拥有一个账户");
		}
	}
	
	public String kaihu(){
		//调用业务方法，向账户表Account中添加账户
		Status s = userBiz.getStatus("active");
		account.setStatus(s);
		userBiz.addAccount(account);
		
		account = userBiz.getAccount(account.getUsername());
		personinfo.setAccount(account);
		personinfoBiz.add(personinfo);
		
		request.put("message", "添加成功");
		return "message";
	}
	
	public String changepwd(){
		Admin a = userBiz.getAdmin(admin.getUsername());
		a.setPwd(admin.getPwd());
		System.out.println("amin name :"+admin.getUsername());
		if (userBiz.updateAdmin(a)) {
			return "message";
		}
		return "login";
	}

	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
