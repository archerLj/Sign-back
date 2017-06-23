package com.archer.controller;

import com.archer.domain.Manager;
import com.archer.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by archerlj on 2017/5/25.
 */
@RestController
public class ManagerController {

    @Autowired
    ManagerService managerService;

    /**
     * 管理端后台登录
     *
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/api/selectManager", method = RequestMethod.POST)
    public Map selectManager(@RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "password", required = true) String password) {
        Manager manager = managerService.findManager(name);
        HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
        if (manager != null && manager.getPassword().equals(password)) {
            resultMap.put("LoginResult", 1); //登录成功
        } else {
            resultMap.put("LoginResult", 0); //登录失败
        }
        return  resultMap;
    }
}
