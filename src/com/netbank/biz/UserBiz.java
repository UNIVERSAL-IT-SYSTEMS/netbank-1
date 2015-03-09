package com.netbank.biz;

import com.netbank.entity.Account;
import com.netbank.entity.Admin;
import com.netbank.entity.Status;

public interface UserBiz {

	public abstract Account getAccount(String username);
	
	public abstract boolean modifyAccount(Account account);
	
	public abstract void reflush(Account account);
	
	public abstract Account getAccount(int accountid);
	
	public abstract Admin getAdmin(String username);
	
	public void enabled(int id);
	
	public void locking(int id);
	
	public boolean delAccount(int id);
	
	public boolean addAccount(Account account);
	
	public Status getStatus(String name);
	
	public boolean updateAdmin(Admin admin);
}
