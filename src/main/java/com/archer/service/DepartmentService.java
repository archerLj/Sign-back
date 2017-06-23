package com.archer.service;

import com.archer.domain.Department;

import java.util.List;

/**
 * Created by archerlj on 2017/5/26.
 */
public interface DepartmentService {
    void addDepartment(String name);
    List<Department> getAllDepartment();
    void removeDepartment(int id);
}
