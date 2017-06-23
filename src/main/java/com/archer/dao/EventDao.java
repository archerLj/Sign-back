package com.archer.dao;

import com.archer.domain.Event;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by archerlj on 2017/5/31.
 */
@Repository
public interface EventDao {
    void addEvent(@Param("userid") Integer userid,
                  @Param("actionType") Integer actionType,
                  @Param("latitude") float latitude,
                  @Param("longtitude") float longtitude,
                  @Param("address") String address,
                  @Param("comment") String comment,
                  @Param("remark") String remark);

    List<Event> getTodayEvent(@Param("startDate") String startDate,
                              @Param("endDate")String endDate,
                              @Param("userid") String userid);

    List<Event> getAllEvents(@Param("startDate") String startDate);
}
