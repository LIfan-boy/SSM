package com.meng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meng.dao.UserDao;
import com.meng.domain.User;
import com.meng.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public User getUserById(User user) {
		return userDao.getUserById(user);
	}

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public int updateUserById(User user) {
		return userDao.updateUserById(user);
	}

	@Override
	public int delUserById(User user) {
		return userDao.delUserById(user);
	}

	@Override
	public User CheckUser(String username, String password) {
		 return userDao.getUserByName(username, password);
	}

}
