package com.myweb.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myweb.dao.UserDao;
import com.myweb.entity.User;
import com.myweb.service.UserService;
@Service(value="serviceImpl")
public class UserServiceImp implements UserService {
	public UserServiceImp(){
		System.out.println("jiaaiiaiidi");
	}
	@SuppressWarnings("unchecked")
	@Resource(name="userDaoImpl")
    UserDao userDao;
    @Override
    public User save(User user) {
        return (User) userDao.save(user);
    }
	public User find(User user) {
		return (User) userDao.find(user);
	}
}