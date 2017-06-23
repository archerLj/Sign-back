package com.archer.service.impl;

import com.archer.dao.ManagerDao;
import com.archer.domain.Manager;
import com.archer.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by archerlj on 2017/5/25.
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerDao managerDao;

    @Override
    public Manager findManager(String name) {
        return managerDao.selectManagerByName(name);
    }
}
