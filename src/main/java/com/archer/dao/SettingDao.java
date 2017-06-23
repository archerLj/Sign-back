package com.archer.dao;

import com.archer.domain.Setting;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by archerlj on 2017/6/2.
 */
@Repository
public interface SettingDao {

    Setting getSetting();

    void updateSetting(@Param("id") int id,
                       @Param("workTime") String workTime,
                       @Param("offWorkTime") String offWorkTime,
                       @Param("checkDay") String checkDay);

    void addSetting(@Param("workTime") String workTime,
                    @Param("offWorkTime") String offWorkTime,
                    @Param("checkDay") String checkDay);

}
