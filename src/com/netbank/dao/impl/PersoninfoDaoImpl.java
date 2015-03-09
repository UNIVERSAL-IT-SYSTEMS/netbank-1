package com.netbank.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.netbank.dao.PersoninfoDao;
import com.netbank.entity.Personinfo;
import com.netbank.entity.Status;
import com.sun.istack.internal.FinalArrayList;

public class PersoninfoDaoImpl extends HibernateDaoSupport implements PersoninfoDao{

	public void modifyPersoninfo(Personinfo personinfo) {
		super.getHibernateTemplate().update(personinfo);
	}

	public List getAllPersoninfo() {
		String hql = "from Personinfo";
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		return query.list();
	}

	public List searchPersoninfo(Status status) {
		String hql = "from Personinfo p where p.account.status.id="+status.getId();
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		return query.list();
	}

	public List searchPersoninfo(final Personinfo personinfo) {
		return super.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException{
				Criteria criteria = session.createCriteria(Personinfo.class);
				if(personinfo.getRealname() != null && !"".equals(personinfo.getRealname())){
					if(personinfo.getCardid() != null){
						criteria.add(Restrictions.or(Restrictions.eq("realname", personinfo.getRealname()), Restrictions.eq("cardid", personinfo.getCardid())));
					}else{
						criteria.add(Restrictions.like("realname", personinfo.getRealname(), MatchMode.ANYWHERE));
					}
				}
				criteria.addOrder(Order.asc("id"));
				return criteria.list();
			}
		});
	}

	public boolean add(Personinfo personinfo) {
		super.getHibernateTemplate().save(personinfo);
		return true;
	}

}
