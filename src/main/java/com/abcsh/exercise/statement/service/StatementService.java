package com.abcsh.exercise.statement.service;

import com.abcsh.exercise.statement.entity.PagingResult;
import com.abcsh.exercise.statement.entity.Result;
import com.abcsh.exercise.statement.entity.Statement;
import com.abcsh.exercise.statement.entity.User;
import com.abcsh.exercise.statement.mapper.StatementMapper;
import com.abcsh.exercise.statement.util.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: Statement
 * @description: CRUD Option
 * @author: 乘梦碧溪
 * @create: 2020-07-03 09:14
 **/
@Service
public class StatementService {
    @Autowired
    StatementMapper statementMapper;
    @Autowired
    HttpServletRequest request;

    //起止时间查询
    public PagingResult retrieveStatementListByRangeDate(String beginDate,String overDate,int currentPage,int pageSize){
        List<?> list = statementMapper.retrieveStatementListByRangeDate( beginDate, overDate, Paging.toStart(currentPage,pageSize),pageSize);
        System.out.println("***************retrieveStatementListByRangeDate*******************" + new Date());
        return new PagingResult<>(
                ((List<Integer>)list.get(1)).get(0)
                ,(List<Statement>)list.get(0)
        );
    }

    //单日时间查询
    public PagingResult retrieveStatementListBySingleDate(String singleDate,int currentPage,int pageSize){
        List<?> list = statementMapper.retrieveStatementListBySingleDate(singleDate,Paging.toStart(currentPage,pageSize),pageSize);
        System.out.println("***************retrieveStatementListBySingleDate*******************" + new Date());
        return new PagingResult<>(
                ((List<Integer>)list.get(1)).get(0)
                ,(List<Statement>)list.get(0)
        );
    }

    //按id查询返回Statement
    public Statement retrieveStatementById(int id){
        return statementMapper.retrieveStatementById(id);
    }

    //新增
    public Result createStatement(Statement statement) {
      try {
          User user = (User) request.getSession().getAttribute("user");
          Date date = new Date();
          SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
          String date_Str = f.format(date);
          statement.setTimeStamp(date_Str);
          statement.setReporter(user.getAccount());
          statementMapper.createStatement(statement);
          System.out.println("++++++++++++");
      }catch (Exception e) {
          return new Result(false,e.getMessage());
      }
      return new Result(true,"");
    }

    //删除
   public Result deleteStatementById(int id) {

        statementMapper.deleteStatementById(id);
        return new Result(true,"");
    }

    //更新
    public Result updateStatementById(int id) {
        try{
            statementMapper.updateStatementById(id);
        }catch (Exception e){
            return new Result(false,e.getMessage());
        }
        return new Result(true,"");
    }


}
