package com.archer.dao;

import com.archer.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by archerlj on 2017/5/27.
 */
@Repository
public interface UserDao {

    User getUserInfoByOpenid(@Param("openid") String openid);
    User getUserByAccount(@Param("account") String account);
    void changePaswd(@Param("phoneNum") String phoneNum, @Param("pswd") String pswd);
    void addUser(@Param("openid") String openid,
                 @Param("name") String name,
                 @Param("jobNum") String jobNum,
                 @Param("department") String department,
                 @Param("phoneNum") String phoneNum,
                 @Param("position") String position,
                 @Param("pswd") String paswd);
}
