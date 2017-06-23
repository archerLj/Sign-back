package com.archer.service.impl;

import com.archer.dao.EventDao;
import com.archer.domain.Event;
import com.archer.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by archerlj on 2017/5/31.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventDao eventDao;

    @Override
    public void addEvent(Integer userid, Integer actionType, float latitude, float longtitude, String address, String comment, String remark) {
        eventDao.addEvent(userid, actionType, latitude, longtitude, address, comment, remark);
    }

    @Override
    public List<Event> getTodayEvents(String startDate, String endDate, String userid) {
        return eventDao.getTodayEvent(startDate, endDate, userid);
    }

    @Override
    public List<Event> getALlEvents(String startDate) {
        return eventDao.getAllEvents(startDate);
    }
}
