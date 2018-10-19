package com.liuz.bplan.controller;

import com.github.pagehelper.Page;
import com.liuz.bplan.dao.TestDao;
import com.liuz.bplan.model.User;
import com.liuz.bplan.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: liuz@aotain.com
 * @Date: 2018/10/16 19:38
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private TestDao dao;
    @Autowired
    private TestService service;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        User user = dao.getUserName();
        return "Hi " + user.getUser() + ", welcome to BabyPlan !";
    }

    @RequestMapping(value = "/page")
    public String page() {
        return "/test/hello";
    }

    @RequestMapping(value = "/json")
    @ResponseBody
    public User json() {
        User user = dao.getUserName();
        return user;
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public Page<User> getAllUsers() {
        return service.listUsers();
    }
}
