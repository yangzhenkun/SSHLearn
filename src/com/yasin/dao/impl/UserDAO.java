package com.yasin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yasin.dao.IUserDAO;
import com.yasin.model.User;

public class UserDAO implements IUserDAO{

	private SessionFactory sessionFactory;	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addOrUpdateUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.merge(user);
		ts.commit();
		session.close();
		return true;
	}

	@Override
	public User checkUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from User where uid='"+user.getUid()+"'and pwd='"+
		user.getPwd()+"'");
		User user1 = new User();
		List list = query.list();
		if(list.size()!=0){
			user1 = (User) list.get(0);
			return user1;
		}
		ts.commit();
		session.close();
		return null;
	}
	
	
}
