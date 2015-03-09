package com.netbank.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.netbank.dao.UserDao;
import com.netbank.entity.Account;
import com.netbank.entity.Admin;
import com.netbank.entity.Status;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	public Account getAccount(String username) {
		String hql = "from Account as a where a.username=:username";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString("username", username);
		return (Account)query.uniqueResult();
	}

	public boolean updateAccount(Account account) {
		super.getHibernateTemplate().merge(account);
		return true;
	}
	
	public void reflush(Account account){
		super.getHibernateTemplate().refresh(account);
	}

	public Account getAccount(int accountid) {
		return (Account)super.getHibernateTemplate().get(Account.class, accountid);
	}

	public Admin getAdmin(String username) {
		String hql = "from Admin as a where a.username=:username";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString("username", username);
		return (Admin)query.uniqueResult();
	}

	public Status getStatus(int id) {
		String hql = "from Status as s where s.id=:id";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		return (Status)query.uniqueResult();
	}

	public Status getStatus(String name) {
		String hql = "from Status as s where s.name=:name";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString("name", name);
		return (Status)query.uniqueResult();
	}

	public boolean delAccount(Account account) {
		super.getHibernateTemplate().delete(account);
		return true;
	}

	public boolean addAccount(Account account) {
		super.getHibernateTemplate().save(account);
		return true;
	}

	public boolean updateAdmin(Admin admin) {
		super.getHibernateTemplate().update(admin);
		return true;
	}

}
