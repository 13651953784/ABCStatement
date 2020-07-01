package com.abcsh.exercise.statement.entity;

/**
 * @program: Statement
 * @description: 返回状态及信息
 * @author: 乘梦碧溪
 * @create: 2020-06-22 13:47
 **/

public class Result {
    private boolean success;
    private  String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
