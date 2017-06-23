package com.archer.domain;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.sql.Timestamp;

/**
 * Created by archerlj on 2017/5/24.
 */
public class Event {
    private int id;
    private User user;
    private int actionType; /* 0: 签到 1:签退 2:外出*/
    private float latitude;
    private float longtitude;
    private String address;
    private Timestamp updateTime;
    private String remark;
    private String comment;

    public Event() {
        super();
    }

    public Event(int id, User user, int actionType, float latitude, float longtitude, String address, Timestamp updateTime, String remark, String comment) {
        this.id = id;
        this.user = user;
        this.actionType = actionType;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.address = address;
        this.updateTime = updateTime;
        this.remark = remark;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", user=" + user +
                ", actionType=" + actionType +
                ", latitude=" + latitude +
                ", longtitude=" + longtitude +
                ", address='" + address + '\'' +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getActionType() {
        return actionType;
    }

    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
