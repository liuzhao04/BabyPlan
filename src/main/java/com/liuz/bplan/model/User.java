package com.liuz.bplan.model;

/**
 * @Author: liuz@aotain.com
 * @Date: 2018/10/17 10:52
 */
public class User {
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                '}';
    }
}
