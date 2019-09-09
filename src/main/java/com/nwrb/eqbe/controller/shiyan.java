package com.nwrb.eqbe.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * @创建人 胡满意
 * @创建时间 2019/7/4
 * @描述
 */
@RestController
@EnableAutoConfiguration
public class shiyan {
    @GetMapping("/api/student")
    public String getStudent(@RequestParam("id") String id){
        return "我是通过get获取学生"+id+"的资料";
    }

    @PostMapping("/api/student")
    public String postStudent(@RequestParam("id") String id){
        return "我是通过post添加学生"+id+"的资料";
    }

    @PutMapping("/api/student")
    public String putStudent(@RequestParam("id") String id){
        return "我是通过put修改学生"+id+"的资料";
    }

    @DeleteMapping("/api/student")
    public String deleteStudent(@RequestParam("id") String id){
        return "我是通过delete删除学生"+id+"的资料";
    }
}
