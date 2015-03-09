package com.netbank.biz;

import java.awt.print.Paper;
import java.util.List;

import com.netbank.entity.Account;
import com.netbank.entity.Pager;
import com.netbank.entity.TransactionLog;

public interface TransactionBiz {

	public boolean deposit(TransactionLog log);
	
	public boolean withdrawal(TransactionLog log);
	
	public boolean transfer(TransactionLog log);
	
	public List getLogs(Account account, int page);
	
	public Pager getPagerOfLogs(Account account);
	
}
