package com.abcsh.exercise.statement.util;

/**
 * @program: Statement
 * @description: 分页计算公式
 * @author: 乘梦碧溪
 * @create: 2020-06-22 16:23
 **/

public class Paging {
    public static int toStart(int currentPage,int pageSize){
        return(currentPage-1)*pageSize;
    }
}
