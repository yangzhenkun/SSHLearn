package com.yasin.service.impl;

import com.yasin.dao.IUserDAO;
import com.yasin.model.User;
import com.yasin.service.IUserService;

public class UserService implements IUserService {

	private IUserDAO userDAO;
	
	
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean addOrUpdateUser(User user) {
		
		return userDAO.addOrUpdateUser(user);
	}

	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
