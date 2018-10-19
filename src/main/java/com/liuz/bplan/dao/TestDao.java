package com.liuz.bplan.dao;

import com.liuz.bplan.annotation.MyBatisDao;
import com.liuz.bplan.model.User;

import java.util.List;

/**
 * @Author: liuz@aotain.com
 * @Date: 2018/10/16 19:26
 */
@MyBatisDao
public interface TestDao {
    public User getUserName();

    public List<User> listUsers();
}
