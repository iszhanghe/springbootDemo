package com.ssy.restfuluser.service;


import com.ssy.restfuluser.bean.User;
import com.ssy.restfuluser.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getUserbyToken(String id, String pwd) {

        if (id == null || id.length() <= 0 || pwd == null || pwd.length() <= 0)
            return null;

        return userDao.getUserbyToken(id, pwd);
    }

}
