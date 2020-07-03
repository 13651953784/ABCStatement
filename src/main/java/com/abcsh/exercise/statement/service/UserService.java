package com.abcsh.exercise.statement.service;

import com.abcsh.exercise.statement.entity.Result;
import com.abcsh.exercise.statement.entity.User;
import com.abcsh.exercise.statement.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Statement
 * @description: 登录注册的service层
 * @author: 乘梦碧溪
 * @create: 2020-06-22 15:53
 **/
@Service
public class UserService {
    @Autowired//它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
            UserMapper userMapper;


    //实现登录功能
    public User getUserByAccount(String account) {

        return userMapper.getUserByAccount(account);
    }


    //实现注册功能
    public Result Register(User user) {
       // System.out.println("**************"+user.getAccount());

        if (null == userMapper.getUserByAccount(user.getAccount())){
            try{
                userMapper.createUserByID(user);
            }catch (Exception e){
                return new Result(false,e.getMessage());
            }
            return new Result(true,String.format("%s",user.getAccount()));
        }else{
            return new Result(false,String.format("%s已经被注册！",user.getAccount()));
        }

    }
}