package com.myweb.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.myweb.dao.UserDao;
import com.myweb.entity.User;
@Repository("userDaoImpl")
public class UserDaoImp implements UserDao<User> {
	@Resource
    HibernateTemplate template;
	@Override
    public User save(User user) {
        template.save(user);
        return template.load(User.class, user.getId());
    }
	
	 public User find(User user) {
		 return (User) template.find("from User mw where mw.username = ?",user.getUsername()).get(0);
	 }

}