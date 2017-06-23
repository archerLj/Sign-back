package com.archer.controller;

import com.archer.domain.Department;
import com.archer.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by archerlj on 2017/5/26.
 */
@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    //UNDO 这里要用事务来处理
    /**
     * 添加部门
     *
     * @param names
     * @return 0: 成功 1:失败
     */
    @RequestMapping(value = "/api/addDepartment", method = RequestMethod.POST)
    public int addDepartment(@RequestParam(value = "names", required = true) ArrayList<String> names) {

        try {
            for (int i=0; i<names.size(); i++) {
                departmentService.addDepartment(names.get(i));
            }
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    /**
     * 获取部门列表
     *
     * @return 所有部门
     */
    @RequestMapping(value = "/api/getAllDepartment", method = RequestMethod.GET)
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartment();
    }


    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/removeDepartment", method = RequestMethod.POST)
    public int removeDepartment(@RequestParam(value = "id", required = true) int id) {
        try {
            departmentService.removeDepartment(id);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
}
