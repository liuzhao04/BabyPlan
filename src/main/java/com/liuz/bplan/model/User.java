package com.liuz.bplan.model;

/**
 * @Author: liuz@aotain.com
 * @Date: 2018/10/17 10:52
 */
public class User {
    private String user;
    private Long id;

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
                ", id=" + id +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {

        return id;
    }

}
