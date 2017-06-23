package com.archer.service;

import com.archer.domain.Event;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by archerlj on 2017/5/31.
 */
public interface EventService {

    void addEvent(Integer userid, Integer actionType, float latitude, float longtitude, String address, String comment, String remark);

    List<Event> getTodayEvents(String startDate, String endDate, String userid);

    List<Event> getALlEvents(String startDate);
}
