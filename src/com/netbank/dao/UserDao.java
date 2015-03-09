package com.netbank.dao;

import com.netbank.entity.Account;
import com.netbank.entity.Admin;
import com.netbank.entity.Status;

public interface UserDao {

	public Account getAccount(String username);
	
	public boolean updateAccount(Account account);
	
	public void reflush(Account account);
	
	public Account getAccount(int accountid);
	
	public Admin getAdmin(String username);
	
	public Status getStatus(int id);
	
	public Status getStatus(String name);
	
	public boolean delAccount(Account account);
	
	public boolean addAccount(Account account);
	
	public boolean updateAdmin(Admin admin);
	
}
