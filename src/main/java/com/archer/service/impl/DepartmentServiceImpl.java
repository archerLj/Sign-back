package com.archer.service.impl;

import com.archer.dao.DepartmentDao;
import com.archer.domain.Department;
import com.archer.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by archerlj on 2017/5/26.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public void addDepartment(String name) {
        departmentDao.insertDepartment(name);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.getAllDepartment();
    }

    @Override
    public void removeDepartment(int id) {
        departmentDao.removeDepartment(id);
    }
}
