package com.abcsh.exercise.statement.controller;

import com.abcsh.exercise.statement.entity.PagingResult;
import com.abcsh.exercise.statement.entity.Result;
import com.abcsh.exercise.statement.entity.Statement;
import com.abcsh.exercise.statement.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: Statement
 * @description: CRUD transmit
 * @author: 乘梦碧溪
 * @create: 2020-07-03 10:11
 **/
@RestController
@RequestMapping("/statement")
public class StatementController {
    @Autowired
    StatementService statementService;
//起始日期查询
    @GetMapping("/beginDate")
    PagingResult retrieveStatementListByRangeDate(@RequestParam String beginDate,
                                                  @RequestParam String overDate,
                                                  @RequestParam int currentPage,
                                                  @RequestParam int pageSize){
        return statementService.retrieveStatementListByRangeDate(beginDate,overDate,currentPage,pageSize);
    }
//单日查询
    @GetMapping("/singleDate")
    PagingResult retrieveStatementListBySingleDate(@RequestParam String singleDate,
                                                  @RequestParam int currentPage,
                                                  @RequestParam int pageSize){
        return statementService.retrieveStatementListBySingleDate(singleDate,currentPage,pageSize);
    }
//新增
    @PostMapping("/add")
    Result createStatement(@RequestBody Statement statement){
        System.out.println("#######@PostMapping(\"/add\")######");
        return statementService.createStatement(statement);
    }
}
