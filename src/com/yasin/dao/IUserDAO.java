package com.yasin.dao;

import com.yasin.model.User;

public interface IUserDAO {
	public boolean addOrUpdateUser(User user);
	public User checkUser(User user);
}
