package com.abcsh.exercise.statement.controller;

import com.abcsh.exercise.statement.entity.Result;
import com.abcsh.exercise.statement.entity.User;
import com.abcsh.exercise.statement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: Statement
 * @description: 登录注册@请求转发
 * @author: 乘梦碧溪
 * @create: 2020-06-22 16:27
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    HttpServletRequest request;

    //实现注册
    @PostMapping("")
    public Result Register(@RequestBody User user){
        return userService.Register(user);
    }

    //实现登录
    @GetMapping("")
    public Result login(@RequestParam  String account,
                        @RequestParam String password){
        User user = userService.getUserByAccount(account);
        if(null == user )
            return new Result(false,String.format("{%s},账户不存在！",user.getAccount()));
        if(!password.equals(user.getPassword()))
            return new Result(false,String.format("{%s},密码不正确！",user.getAccount()));
        request.getSession(true).setAttribute("user",user);

        return  new Result(true,"");
    }

    @GetMapping("/me")
    public String forTestOnly(){
        return "hello world";
    }
}
