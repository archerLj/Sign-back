package com.archer.service.impl;

import com.archer.dao.UserDao;
import com.archer.domain.User;
import com.archer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by archerlj on 2017/5/27.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public User getUserByOpenid(String openid) {
        return userDao.getUserInfoByOpenid(openid);
    }

    @Override
    public User getUserByAccount(String account) {
        return userDao.getUserByAccount(account);
    }

    @Override
    public void changePassword(String phoneNum, String paswd) {
        userDao.changePaswd(phoneNum, paswd);
    }

    @Override
    public void addUser(String openid, String name, String jobNum, String department, String phoneNum, String position, String paswd) {
        userDao.addUser(openid, name, jobNum, department, phoneNum, position, paswd);
    }
}
