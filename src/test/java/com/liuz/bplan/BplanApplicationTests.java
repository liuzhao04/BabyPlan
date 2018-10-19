package com.liuz.bplan;

import com.github.pagehelper.Page;
import com.liuz.bplan.dao.TestDao;
import com.liuz.bplan.model.User;
import com.liuz.bplan.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BplanApplicationTests {

    @Autowired
    private TestDao dao;

    @Autowired
    private TestService service;

    @Test
    public void contextLoads() {
        System.out.println("====================="+dao.getUserName());
        System.out.println(dao.listUsers());
        Page<User> result = service.listUsers();
        System.out.println(result);
        System.out.println(result.getResult());
    }

}
