package com.liuz.bplan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liuz.bplan.dao.TestDao;
import com.liuz.bplan.model.User;
import com.liuz.bplan.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao dao;

    @Override
    public Page<User> listUsers() {
        Page<User> result = PageHelper.startPage(1, 10);
        dao.listUsers();
        System.out.println(result.getResult());
        return result;
    }
}
