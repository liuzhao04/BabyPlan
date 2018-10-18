package com.liuz.bplan.controller;

import com.liuz.bplan.dao.TestDao;
import com.liuz.bplan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: liuz@aotain.com
 * @Date: 2018/10/16 19:38
 */
@Controller
@RequestMapping(value="/test")
public class TestController {
    @Autowired
    private TestDao dao;

    @RequestMapping(value="/hello")
    @ResponseBody
    public String hello(){
        String userName = dao.getUserName();
        return "Hi "+userName+", welcome to BabyPlan !";
    }

    @RequestMapping(value="/page")
    public String page(){
        return "/test/hello";
    }

    @RequestMapping(value="/json")
    @ResponseBody
    public User json(){
        String userName = dao.getUserName();
        User user = new User();
        user.setUser(userName);
        return user;
    }
}
