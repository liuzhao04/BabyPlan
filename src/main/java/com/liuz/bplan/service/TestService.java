package com.liuz.bplan.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.liuz.bplan.model.User;

import java.util.List;

public interface TestService {
    public Page<User> listUsers();
}
