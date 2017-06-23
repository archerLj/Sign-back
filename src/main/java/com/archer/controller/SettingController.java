package com.archer.controller;

import com.archer.domain.Setting;
import com.archer.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by archerlj on 2017/6/2.
 */
@RestController
public class SettingController {

    @Autowired
    SettingService settingService;

    /**
     * 获取设置（上班时间，下班时间，考核日等）
     *
     * @return
     */
    @RequestMapping(value = "/api/getSetting", method = RequestMethod.GET)
    public Setting getSetting() {
        return settingService.getSetting();
    }


    /**
     * 更新设置
     *
     * @param id
     * @param workTime
     * @param offWorkTIme
     * @param checkDay
     * @return
     */
    @RequestMapping(value = "/api/updateSetting", method = RequestMethod.POST)
    public int updateSetting(@RequestParam(value = "id", required = true) int id,
                             @RequestParam(value = "workTime", required = true) String workTime,
                             @RequestParam(value = "offWorkTime", required = true) String offWorkTIme,
                             @RequestParam(value = "checkDay", required = true) String checkDay) {
        try {
            settingService.updateSetting(id, workTime, offWorkTIme, checkDay);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }


    /**
     * 添加设置
     *
     * @param workTime
     * @param offWorkTIme
     * @param checkDay
     * @return
     */
    @RequestMapping(value = "/api/addSetting", method = RequestMethod.POST)
    public int addSetting(@RequestParam(value = "workTime", required = true) String workTime,
                          @RequestParam(value = "offWorkTime", required = true) String offWorkTIme,
                          @RequestParam(value = "checkDay", required = true) String checkDay) {
        try {
            settingService.addSetting(workTime, offWorkTIme, checkDay);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
}
