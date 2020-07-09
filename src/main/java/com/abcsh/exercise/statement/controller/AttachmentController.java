package com.abcsh.exercise.statement.controller;

import com.abcsh.exercise.statement.entity.Result;
import com.abcsh.exercise.statement.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.stream.Collectors;

/**
 * @Author 乘梦碧溪
 * @Date 2020/7/6 20:30
 * @Version 1.0
 */
@Controller
@RequestMapping("/attachment")
public class AttachmentController {

    private final StorageService storageService;
    @Autowired
    public AttachmentController(StorageService storageService) {
        this.storageService = storageService;
       //System.out.println(storageService.rootLocation);
    }

    @GetMapping("")
    public Model listUploadFiles(Model model){
        return model.addAttribute("files",storageService.loadAll().map(
                path -> MvcUriComponentsBuilder
                        .fromMethodName(AttachmentController.class,
                                "serveFile",
                                path.getFileName().toString())
                        .build().toUri().toString())
                .collect(Collectors.toList()));
    }

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> download(@PathVariable String filename){
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\"" + file.getFilename() + "\"").body(file);
    }


    @PostMapping()
    public ResponseEntity upload(@RequestParam("file") MultipartFile file){
        return ResponseEntity.ok(storageService.store(file).getMessage());
    }


    @DeleteMapping()
    public Result clean(){
        return storageService.deleteAll();
    }
}
