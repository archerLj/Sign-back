package com.archer.dao;

import com.archer.domain.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by archerlj on 2017/5/26.
 */
@Repository
public interface DepartmentDao {
    public void insertDepartment(@Param("name") String name);
    public List<Department> getAllDepartment();
    public void removeDepartment(@Param("id") int id);
}
