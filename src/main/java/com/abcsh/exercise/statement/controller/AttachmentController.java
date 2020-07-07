package com.abcsh.exercise.statement.controller;

import com.abcsh.exercise.statement.entity.Result;
import com.abcsh.exercise.statement.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author 乘梦碧溪
 * @Date 2020/7/6 20:30
 * @Version 1.0
 */
@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    StorageService storageService;

    public Result addAttachement(@RequestParam("attachment") MultipartFile file){
        return storageService.store(file);
    }
}
