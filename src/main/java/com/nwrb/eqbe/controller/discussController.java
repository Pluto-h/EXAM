package com.nwrb.eqbe.controller;

import com.nwrb.eqbe.entity.discuss;
import com.nwrb.eqbe.mapper.discussMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class discussController {

    @Autowired
    private discussMapper discussMapper;

    @GetMapping("/user/discuss/all")
    public Map<String, Object> choose(int id){
        Map<String,Object> result = new HashMap<>();
        try {
            discuss selectDiscuss = discussMapper.selectDiscuss(id);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectDiscuss);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }

    @GetMapping("/user/discuss/next")
    public Map<String, Object> selectDiscussNext(int discussCategory, int id){
        Map<String,Object> result = new HashMap<>();
        try {
            discuss selectDiscussNext = discussMapper.selectDiscussNext(discussCategory,id);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectDiscussNext);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }

    @GetMapping("/user/discuss/before")
    public Map<String, Object> selectDiscussBefore(int discussCategory, int id){
        Map<String,Object> result = new HashMap<>();
        try {
            discuss selectDiscussBefore = discussMapper.selectDiscussBefore(discussCategory,id);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectDiscussBefore);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }

    @GetMapping("/user/discuss/random")
    public Map<String,Object> selectDiscussRandom(int discussSubject){
        Map<String,Object> result = new HashMap<>();
        try {
            List<discuss> selectDiscussRandom = discussMapper.selectDiscussRandom(discussSubject);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectDiscussRandom);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }
}
