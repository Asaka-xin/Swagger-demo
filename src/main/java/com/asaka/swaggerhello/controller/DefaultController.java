package com.asaka.swaggerhello.controller;


import com.asaka.swaggerhello.config.ReadConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/*
 *@Author Asaka
 *@Date 2023/2/16 0:29
 */

@Tag(name = "默认分类")
@RestController
@RequestMapping("/default")
public class DefaultController {
    @Resource
    ReadConfig readConfig;



    @Operation(summary = "默认信息")
    @Parameter(name = "id" , required = false, description = "序号")
    @Parameter(name = "name",required = true, description = "姓名")
    @GetMapping("/hello")
    public String index(){
        return "Hello Swagger3!";
    }

    @RequestMapping("/test")
    public ResponseEntity<ReadConfig> test(){
        return ResponseEntity.ok(readConfig);
    }
}
