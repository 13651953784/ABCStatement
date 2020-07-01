package com.abcsh.exercise.statement.entity;

/**
 * @program: Statement
 * @description: 用户表
 * @author: 乘梦碧溪
 * @create: 2020-06-22 13:53
 **/

public class User {
    private String account;
    private String name;
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
