package com.abcsh.exercise.statement.entity;

import java.util.List;

/**
 * @program: Statement
 * @description: ????
 * @author: 乘梦碧溪
 * @create: 2020-06-22 11:39
 **/

public class PagingResult <T>{
    private int total;
    private List<T> rows;

    public PagingResult(int total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
