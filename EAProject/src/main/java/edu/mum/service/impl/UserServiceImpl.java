package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import edu.mum.domain.UserCredentials;
import edu.mum.service.UserCredentialsService;
import edu.mum.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	UserCredentialsService credentialsService;

	public void save(User user) {
//		UserCredentials userCredentials = credentialsService.findByUserName(user.getUserCredentials().getUsername());
//		if(userCredentials != null)
//			throw 
		userDao.save(user);
	}

	public User update(User user) {
		return userDao.update(user);

	}

	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	@Override
	public User findOne(Long id) {
		return userDao.findOne(id);
	}

	@Override
	public void delete(Long id) {
		userDao.delete(id);
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	public User testRefresh(User user) {
		user.setEmail("Lotta@Doe.com");
		userDao.save(user);

		return user;
	}

	public void saveFull(User user) {
		user.setAdmin(false);
		credentialsService.save(user.getUserCredentials());
		userDao.update(user);
	}

}
