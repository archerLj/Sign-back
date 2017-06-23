package com.archer.controller;

import com.archer.domain.User;
import com.archer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by archerlj on 2017/5/27.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取用户信息（微信小程序端用）
     *
     * @param openid
     * @return User
     */
    @RequestMapping(value = "/api/getUser", method = RequestMethod.GET)
    public User getUserByOpenid(@RequestParam(value = "openid", required = true) String openid) {
        return userService.getUserByOpenid(openid);
    }

    /**
     * 用户注册
     *
     * @param openid
     * @param name
     * @param jobNum
     * @param department
     * @param phoneNum
     * @param position
     * @return User
     */
    @RequestMapping(value = "/api/addUser", method = RequestMethod.POST)
    public User addUser(String openid,
                       @RequestParam("name") String name,
                       @RequestParam("jobNum") String jobNum,
                       @RequestParam("department") String department,
                       @RequestParam("phoneNum") String phoneNum,
                       @RequestParam("position") String position,
                        String paswd) {
        try {
            userService.addUser(openid, name, jobNum, department, phoneNum, position, paswd);
            if (openid == null || openid.isEmpty()) {
                return userService.getUserByAccount(phoneNum);
            } else {
                return userService.getUserByOpenid(openid);
            }

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 用户登录（iOS&android APP端用， 非微信小程序)
     *
     * @param account
     * @param pswd
     * @return
     */
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public User login(@RequestParam(value = "account", required = true) String account,
                      @RequestParam(value = "pswd", required = true) String pswd) {

        try {
            User user = userService.getUserByAccount(account);
            logger.info("登录: user account" + account);
            if (user != null && user.getPswd().equals(pswd)) {
                return user;
            } else  {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(value = "/api/changePaswd", method = RequestMethod.POST)
    public int changePaswd(@RequestParam(value = "phoneNum", required = true) String phoneNum,
                           @RequestParam(value = "paswd", required = true) String paswd) {

        try {

            userService.changePassword(phoneNum, paswd);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
}
