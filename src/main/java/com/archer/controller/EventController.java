package com.archer.controller;

import com.archer.domain.Event;
import com.archer.domain.Setting;
import com.archer.service.EventService;
import com.archer.service.SettingService;
import com.sun.javafx.tools.ant.DeployFXTask;
import org.codehaus.groovy.util.ListHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by archerlj on 2017/5/31.
 */
@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    SettingService settingService;

    /**
     * 增加事件（签到， 签退或外出事件）
     *
     * @param userid
     * @param actionType
     * @param latitude
     * @param longtitude
     * @param address
     * @param comment
     * @return
     */
    @RequestMapping(value = "/api/addEvent", method = RequestMethod.POST)
    public int addEvent(@RequestParam(value = "userid", required = true) Integer userid,
                         @RequestParam(value = "actionType", required = true) Integer actionType,
                         @RequestParam(value = "latitude", required = true) float latitude,
                         @RequestParam(value = "longtitude", required = true) float longtitude,
                         @RequestParam(value = "address", required = true) String address, String comment) {

        try {

            Setting setting = settingService.getSetting();

            String remark = "";

            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String dateStr = fmt.format(new Date());
            String startTime = dateStr + " " + setting.getWorkTime() + ":00"; //上班时间
            Date startDate = fmt2.parse(startTime);

            String endTime = dateStr + " " + setting.getOffWorkTime() + ":00"; //下班时间
            Date endDate = fmt2.parse(endTime);

            switch (actionType) {
                case 0: //签到
                    if (new Date().getTime() > startDate.getTime()) {
                        remark = "迟到";
                    } else {
                        remark = "正常";
                    }
                    break;
                case 1: //签退
                    if (new Date().getTime() < endDate.getTime()) {
                        remark = "早退";
                    } else {
                        remark = "正常";
                    }
                    break;
                default: //外出
                    if (new Date().getTime() > startDate.getTime() && new Date().getTime() < endDate.getTime()) {
                        remark = "正常";
                    } else  {
                        remark = "额外时间";
                    }
                    break;
            }
            eventService.addEvent(userid, actionType, latitude, longtitude, address, comment, remark);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    /**
     * 获取当天已经提交的事件。
     *
     * @param userid
     * @return
     */
    @RequestMapping(value = "/api/getTodayEvents", method = RequestMethod.GET)
    public List<Map<String, Object>> getTodayEvents(@RequestParam(value = "userid", required = true) String userid) {

        try {

            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = fmt.format(new Date());

            List<Event> events = eventService.getTodayEvents(dateStr + " 00:00:00", dateStr + " 23:59:59", userid);
            return smallEvents(events);

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取所有的事件（从上个月的考核日到现在的所有事件）
     *
     * @param userid
     * @return
     */
    @RequestMapping(value = "/api/getAllEvents", method = RequestMethod.GET)
    public List<Map<String, Object>> getAllEvents(@RequestParam(value = "userid", required = true) String userid) {

        Setting setting = settingService.getSetting();

        Calendar calendar = Calendar.getInstance();
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        if (dayOfMonth < 10) {
            calendar.add(Calendar.MONTH, -1);
        }

        Date lastMonthDay = calendar.getTime();
        SimpleDateFormat fmt = new SimpleDateFormat("yyy-MM");
        String lastMonthDayStr = fmt.format(lastMonthDay) + "-" + setting.getCheckDay() + " 00:00:00";


        try {
            List<Event> events = eventService.getALlEvents(lastMonthDayStr);
            return smallEvents(events);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * 将原始events列表元素提取重新组成新的列表
     *
     */
    private List<Map<String, Object>> smallEvents(List<Event> events) {

        List<Map<String, Object>> resultMap = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int i=0; i<events.size(); i++) {
            Map<String, Object> tempMap = new HashMap<>();
            Event event = events.get(i);

            tempMap.put("actionType", event.getActionType());
            tempMap.put("updateTime", simpleDateFormat.format(event.getUpdateTime())); //时间戳转日期
            tempMap.put("remark", event.getRemark());
            tempMap.put("comment", event.getComment());

            resultMap.add(tempMap);
        }

        return resultMap;
    }
}
