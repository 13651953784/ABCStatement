package com.abcsh.exercise.statement.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: Statement
 * @description: ......
 * @author: 乘梦碧溪
 * @create: 2020-06-22 14:01
 **/
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
