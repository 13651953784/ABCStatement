package com.abcsh.exercise.statement.mapper;

import com.abcsh.exercise.statement.entity.Result;
import com.abcsh.exercise.statement.entity.Statement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatementMapper {
    //
    List<?> retrieveAllStatementList(int start,int limit);
    //起始时间查询
    List<?> retrieveStatementListByRangeDate(String beginDate,String overDate,int start,int limit);
    //单日查询
    List<?> retrieveStatementListBySingleDate(String singleDate,int start,int limit);
    //通过id返回一个Statement类
    Statement retrieveStatementById(int id);
    //新增
    void createStatement(Statement statement);
    //删除
    boolean deleteStatementById(int id);
    //更新
    boolean updateStatementById(Statement statement);
}
