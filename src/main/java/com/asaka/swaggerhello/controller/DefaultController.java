package com.asaka.swaggerhello.controller;
/*
 *@Author Asaka
 *@Date 2023/2/16 0:29
 */


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "默认分类")
@RestController
@RequestMapping("/default")
public class DefaultController {

    @Operation(summary = "默认信息")
    @Parameter(name = "id" , required = false, description = "序号")
    @GetMapping("/hello")
    public String index(){
        return "Hello Swagger3!";
    }
}
