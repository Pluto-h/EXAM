package com.nwrb.eqbe.controller;

import com.nwrb.eqbe.entity.judgment;
import com.nwrb.eqbe.mapper.judgmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class judgmentController {

    @Autowired
    private judgmentMapper judgmentMapper;

    @GetMapping("/user/judgment/all")
    public Map<String,Object> selectJudgment(int id){
        Map<String,Object> result = new HashMap<>();
        try {
            judgment selectJudgment = judgmentMapper.selectJudgment(id);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectJudgment);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }

    @GetMapping("/user/judgment/next")
    public Map<String,Object> selectJudgmentNext(int judgmentCategory,int id){
        Map<String,Object> result = new HashMap<>();
        try {
            judgment selectJudgmentNext = judgmentMapper.selectJudgmentNext(judgmentCategory,id);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectJudgmentNext);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }

    @GetMapping("/user/judgment/before")
    public Map<String,Object> selectJudgmentBefore(int judgmentCategory,int id){
        Map<String,Object> result = new HashMap<>();
        try {
            judgment selectJudgmentBefore = judgmentMapper.selectJudgmentBefore(judgmentCategory,id);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectJudgmentBefore);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }

    @GetMapping("/user/judgment/random")
    public Map<String,Object> selectJudgmentRandom(int judgmentSubject){
        Map<String,Object> result = new HashMap<>();
        try {
            List<judgment> selectJudgmentRandom = judgmentMapper.selectJudgmentRandom(judgmentSubject);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectJudgmentRandom);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }
}
