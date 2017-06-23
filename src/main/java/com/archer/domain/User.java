package com.archer.domain;

import javax.jws.soap.SOAPBinding;

/**
 * Created by archerlj on 2017/5/24.
 */
public class User {
    private int id;
    private String openid;
    private String name;
    private String jobNum;
    private Department department;
    private String phoneNum;
    private String position;
    private String pswd;

    public User() {
        super();
    }

    public User(int id, String openid, String name, String jobNum, Department department, String phoneNum, String position, String pswd) {
        this.id = id;
        this.openid = openid;
        this.name = name;
        this.jobNum = jobNum;
        this.department = department;
        this.phoneNum = phoneNum;
        this.position = position;
        this.pswd = pswd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", name='" + name + '\'' +
                ", jobNum='" + jobNum + '\'' +
                ", department=" + department +
                ", phoneNum='" + phoneNum + '\'' +
                ", position='" + position + '\'' +
                ", pswd='" + pswd + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
}
