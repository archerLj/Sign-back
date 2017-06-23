package com.archer.service;

import com.archer.domain.User;

/**
 * Created by archerlj on 2017/5/27.
 */
public interface UserService {

    User getUserByOpenid(String openid);
    User getUserByAccount(String account);
    void changePassword(String phoneNum, String paswd);
    void addUser(String openid, String name, String jobNum, String department, String phoneNum, String position, String paswd);
}
