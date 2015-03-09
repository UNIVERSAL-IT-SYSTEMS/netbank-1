package com.netbank.action;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.netbank.biz.TransactionBiz;
import com.netbank.biz.UserBiz;
import com.netbank.entity.Account;
import com.netbank.entity.Pager;
import com.netbank.entity.TransactionLog;
import com.opensymphony.xwork2.ActionSupport;

public class Transaction extends ActionSupport implements RequestAware,SessionAware{

	private UserBiz userBiz;
	public void setUserBiz(UserBiz userBiz){
		this.userBiz = userBiz;
	}
	
	private TransactionBiz transactionBiz;
	public void setTransactionBiz(TransactionBiz transactionBiz){
		this.transactionBiz = transactionBiz;
	}
	
	Map<String, Object> request;
	Map<String, Object> session;
	
	private Account account;
	
	private TransactionLog log;
	private Pager pager;
	public TransactionLog getLog() {
		return log;
	}
	public void setLog(TransactionLog log) {
		this.log = log;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	public String deposit(){
		//调用自定义方法判断账户是否冻结
		if(isEnable()){
			//使用执行isEnable方法从session中重新获取的账户对象，给交易信息对象log中关联的账户对象属性赋值
			log.setAccount(account);
			session.put("user", account);
			//调用业务方法，更新账户表中的余额，并在交易信息表中添加交易记录
			return isSuccess(transactionBiz.deposit(log));
		}
		return "message";
	}
	
	private boolean isEnable(){
		//从session中重新获取account对象，该对象在登陆成功时已保存到session中。
		userBiz.reflush(account);
		if(account.getStatus().getName().equals("frozen")){
			request.put("message", "对不起！该账户已被冻结，无法进行相关操作<br>");
			return false;
		}
		return true;
	}
	
	private String isSuccess(boolean flag) {
		if (flag) {
			request.put("message", "操作成功！");
			return "message";
		}
		request.put("message", "操作失败！<a href='javascript:history.go(-1)'>返回</a>");
		return "message";
	}

	public void validateWithdrawal(){
		//比较取款页面输入的金额与账户余额
		if (log.getTrMoney() > account.getBalance().longValue()) {
			this.addFieldError("log.trMoney", "您的账户余额不足！");
		}
	}
	
	public String withdrawal(){
		//调用自定义方法判断账户是否冻结
		if(isEnable()){
			//使用执行isEnable方法从session中重新获取的账户对象，给交易信息对象log中关联的账户对象属性赋值
			log.setAccount(account);
			session.put("user", account);
			//调用业务方法，更新账户表中的余额，并在交易信息表中添加交易记录
			return isSuccess(transactionBiz.withdrawal(log));
		}
		return "message";
	}
	
	public void validateTransfer(){
		if (log.getOtherid().intValue()==account.getAccountid().intValue()) {
			this.addFieldError("log.otherid", "不能转账给自己");
		}
		if (userBiz.getAccount(log.getOtherid())==null) {
			this.addFieldError("log.otherid", "该账户不存在！");
		}
		if (log.getTrMoney() > account.getBalance().intValue()) {
			this.addFieldError("log.trMoney", "账户余额不足");
		}
	}
	
	public String transfer() {
		if(isEnable()){
			log.setAccount(account);
			session.put("user", account);
			return isSuccess(transactionBiz.transfer(log));
		}
		return "message";
	}
	
	public String list(){
		int curPage = pager.getCurPage();
		System.out.println("curPage: "+ curPage);
		List<TransactionLog> logs = transactionBiz.getLogs(account, curPage);
		//获得账户的交易记录总数，用来初始化分页类 pager对象，并设置其perPagerows rowcount pagecount
		pager = transactionBiz.getPagerOfLogs(account);
		//设置pager对象中的待显示页 页码
		pager.setCurPage(curPage);
		request.put("logs", logs);
		return "success";
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
		account = (Account)session.get("user");
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
