package com.netbank.biz.impl;

import java.awt.print.Paper;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.netbank.biz.TransactionBiz;
import com.netbank.dao.TransactionDao;
import com.netbank.dao.UserDao;
import com.netbank.entity.Account;
import com.netbank.entity.Pager;
import com.netbank.entity.TransactionLog;
import com.netbank.entity.TransactionType;

public class TransactionBizImpl implements TransactionBiz{

	TransactionDao transactionDao;
	public void setTransactionDao(TransactionDao transactionDao){
		this.transactionDao = transactionDao;
	}
	
	UserDao userDao;
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	
	public boolean deposit(TransactionLog log) {
		
		Account self = log.getAccount();
		//将账户金额与存款金额相加
		BigDecimal total = log.getAccount().getBalance().add(BigDecimal.valueOf(log.getTrMoney()));
		self.setBalance(total);
		userDao.updateAccount(self);
		
		//根据交易类型获取交易类型对象
		TransactionType type = transactionDao.geTransactionType("deposit");
		log.setTransactionType(type);
		log.setOtherid(self.getAccountid());
		//向数据表transaction_log中添加交易记录
		return transactionDao.addLog(log);
	}


	public boolean withdrawal(TransactionLog log) {
		Account self = log.getAccount();
		//将账户金额与存款金额相加
		BigDecimal total = log.getAccount().getBalance().subtract(BigDecimal.valueOf(log.getTrMoney()));
		self.setBalance(total);
		userDao.updateAccount(self);
		
		//根据交易类型获取交易类型对象
		TransactionType type = transactionDao.geTransactionType("withdrawal");
		log.setTransactionType(type);
		log.setOtherid(self.getAccountid());
		//向数据表transaction_log中添加交易记录
		return transactionDao.addLog(log);
	}


	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	public boolean transfer(TransactionLog log) {
		//获取入账方账户对象
		Account other = userDao.getAccount(log.getOtherid());
		//获取转账方账户对象
		Account self = log.getAccount();
		if (other != null) {
			//修改转账方账户余额
			self.setBalance(log.getAccount().getBalance().subtract(BigDecimal.valueOf(log.getTrMoney())));
			//修改入账方账户余额
			other.setBalance(other.getBalance().add(BigDecimal.valueOf(log.getTrMoney())));
			//将转账方账户余额更新到数据表Account
			userDao.updateAccount(self);
			userDao.updateAccount(other);
			TransactionType type = transactionDao.geTransactionType("transfer");
			log.setTransactionType(type);
			return transactionDao.addLog(log);		
		}
		return false;
	}


	public List getLogs(Account account, int page) {
		return transactionDao.getLogs(account, page);
	}


	public Pager getPagerOfLogs(Account account) {
		int count = transactionDao.getCountOfLogs(account);
		//使用分页类Pager定义对象
		Pager pager = new Pager(); 
		pager.setPerPageRows(10);
		pager.setRowCount(count);
		pager.setPageCount(count%10 == 0 ? count/10:(count/10 + 1));
		return pager;
	}

}
