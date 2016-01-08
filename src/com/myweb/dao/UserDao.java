package com.myweb.dao;
import com.myweb.entity.User;
public interface UserDao<T> {
    T save(User user);

    T find(User user);
}