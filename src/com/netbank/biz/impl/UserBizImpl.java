package com.netbank.biz.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.netbank.biz.UserBiz;
import com.netbank.dao.UserDao;
import com.netbank.entity.Account;
import com.netbank.entity.Admin;
import com.netbank.entity.Status;

//使用@Transactional注解实现事务管理
@Transactional
public class UserBizImpl implements UserBiz{

	//使用UserDao接口对象，并提供依赖注入方法
	UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public Account getAccount(String username) {
		return userDao.getAccount(username);
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public boolean modifyAccount(Account account) {
		return userDao.updateAccount(account);		
	}

	public void reflush(Account account) {
		userDao.reflush(account);
	}

	@Transactional(readOnly=true)
	public Account getAccount(int accountid) {
		return userDao.getAccount(accountid);
	}

	public Admin getAdmin(String username) {
		return userDao.getAdmin(username);
	}

	public void enabled(int id) {
		Account account = userDao.getAccount(id);
		Status status = userDao.getStatus("active");
		account.setStatus(status);
		userDao.updateAccount(account);
	}

	public void locking(int id) {
		Account account = userDao.getAccount(id);
		Status status = userDao.getStatus("frozen");
		account.setStatus(status);
		userDao.updateAccount(account);
	}

	public boolean delAccount(int id) {
		Account account = userDao.getAccount(id);
		return userDao.delAccount(account);
	}

	public boolean addAccount(Account account) {
		Status status = userDao.getStatus("active");
		account.setStatus(status);
		return userDao.addAccount(account);
	}

	public Status getStatus(String name) {
		return userDao.getStatus(name);
	}

	public boolean updateAdmin(Admin admin) {
		return userDao.updateAdmin(admin);
	}
	

}
