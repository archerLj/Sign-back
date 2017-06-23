package com.archer.service.impl;

import com.archer.dao.SettingDao;
import com.archer.domain.Setting;
import com.archer.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by archerlj on 2017/6/2.
 */
@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    SettingDao settingDao;

    @Override
    public Setting getSetting() {
        return settingDao.getSetting();
    }

    @Override
    public void updateSetting(int id, String workTime, String offWorkTime, String checkDay) {
        settingDao.updateSetting(id, workTime, offWorkTime, checkDay);
    }

    @Override
    public void addSetting(String workTime, String offWorkTime, String checkDay) {
        settingDao.addSetting(workTime, offWorkTime, checkDay);
    }
}
