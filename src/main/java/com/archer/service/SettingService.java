package com.archer.service;

import com.archer.domain.Setting;
import org.apache.ibatis.annotations.Param;

/**
 * Created by archerlj on 2017/6/2.
 */
public interface SettingService {

    Setting getSetting();

    void updateSetting(int id, String workTime, String offWorkTime, String checkDay);

    void addSetting(String workTime, String offWorkTime, String checkDay);
}
