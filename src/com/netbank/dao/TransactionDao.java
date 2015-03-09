package com.netbank.dao;

import java.util.List;

import com.netbank.entity.Account;
import com.netbank.entity.TransactionLog;
import com.netbank.entity.TransactionType;

public interface TransactionDao {

	//根据交易类型名称获取交易类型对象
	public TransactionType geTransactionType(String name);
	
	//向数据表transaction_log中添加交易记录
	public boolean addLog(TransactionLog log);
	
	public List getLogs(Account account,int page);
	
	public Integer getCountOfLogs(Account account);
}
