package com.yasin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yasin.dao.ICardDAO;
import com.yasin.model.Card;
import com.yasin.model.User;

public class CardDAO implements ICardDAO {

	SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public Integer addCard(Card card) {
		Integer cid=null;
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.merge(card);
		Query query = session.createQuery("from Card order by cid desc");
		query.setFirstResult(0);
		query.setMaxResults(1);
		List list = query.list();
		cid = ((Card)list.get(0)).getCid();
		ts.commit();
		session.close();
		System.out.println(cid);
		return cid;
	}


	@Override
	public Boolean deleteCard(Card card) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.delete(card);
		ts.commit();
		session.close();
		return true;
	}


	@Override
	public Boolean updateCard(Card card) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		/*Query query = session.createQuery("from Card where cid="+card.getCid());
		List list = query.list();
		if(list.size()==0){
			return false;
		})*/
		try{
			session.update(card);
		}catch(Exception e){
			e.printStackTrace();
			session.close();
			return false;
		}
		ts.commit();
		session.close();
		return true;
	}


	@Override
	public List getAllCard(String uid) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Card where uid="+uid);
		List list = query.list();
		ts.commit();
		session.close();
		return list;
	}
	
}
