package com.abcsh.exercise.statement.controller;

import com.abcsh.exercise.statement.entity.PagingResult;
import com.abcsh.exercise.statement.entity.Result;
import com.abcsh.exercise.statement.entity.Statement;
import com.abcsh.exercise.statement.service.StatementService;
import com.abcsh.exercise.statement.service.StorageService;
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
    @Autowired
    StorageService storageService;
//查询所有
    @GetMapping("/findAll")
    PagingResult retrieveAllStatementList(@RequestParam int currentPage,
                                          @RequestParam int pageSize){
        System.out.println(">>>>>>>>findAll<<<<<<<<<<");
        return statementService.retrieveAllStatementList(currentPage,pageSize);
    }
//起始日期查询
    @GetMapping("/beginDate")
    PagingResult retrieveStatementListByRangeDate(@RequestParam String beginDate,
                                                  @RequestParam String overDate,
                                                  @RequestParam int currentPage,
                                                  @RequestParam int pageSize){
        System.out.println(">>>>>>>>>beginDate+overDate:"+beginDate+overDate);
        return statementService.retrieveStatementListByRangeDate(beginDate,overDate,currentPage,pageSize);
    }
//单日查询
    @GetMapping("/singleDate")
    PagingResult retrieveStatementListBySingleDate(@RequestParam String singleDate,
                                                  @RequestParam int currentPage,
                                                  @RequestParam int pageSize){
        System.out.println(">>>>>>>>>singleDate:"+singleDate);
        return statementService.retrieveStatementListBySingleDate(singleDate,currentPage,pageSize);
    }
//新增
    @PostMapping("/add")
    Result createStatement(@RequestBody Statement statement){
        System.out.println("#######@PostMapping(\"/add\")######");
        return statementService.createStatement(statement);
    }
//删除，即为更新
    @RequestMapping(value = "/delete{rowId}",method=RequestMethod.DELETE)
    Result deleteStatementById(@PathVariable String rowId){
        System.out.println("###########ID:"+rowId);
        int id = Integer.parseInt(rowId);
        return statementService.deleteStatementById(id);
    }
//编辑,即为更新,即为新增
    @RequestMapping(value="/update{rowId}",method=RequestMethod.POST)
    Result updateStatementById(@RequestParam String rowId,
                               @RequestBody Statement statement
    ){
        //Statement statement = statementService.retrieveStatementById(id);
        int id = Integer.parseInt(rowId);
        System.out.println(">>>>>>>>>>>正在执行更新Controller操作...");
        return statementService.updateStatementById(id,statement);
    }
}
