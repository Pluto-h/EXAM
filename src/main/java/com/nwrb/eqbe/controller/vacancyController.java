package com.nwrb.eqbe.controller;


import com.nwrb.eqbe.entity.vacancy;
import com.nwrb.eqbe.mapper.vacancyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@EnableAutoConfiguration
public class vacancyController {
    @Autowired
    private vacancyMapper vacancyMapper;

    @GetMapping("/user/vacancy/all")
    public Map<String,Object> selectVacancy(int id){
        Map<String,Object> result = new HashMap<>();
        try {
            vacancy selectVacancy = vacancyMapper.selectVacancy(id);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectVacancy);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }

    @GetMapping("/user/vacancy/next")
    public Map<String,Object> selectVacancyNext(int vacancyCategory,int id){
        Map<String,Object> result = new HashMap<>();
        try {
            vacancy selectVacancyNext = vacancyMapper.selectVacancyNext(vacancyCategory,id);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectVacancyNext);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }

    @GetMapping("/user/vacancy/before")
    public Map<String,Object> selectVacancyBefore(int vacancyCategory,int id){
        Map<String,Object> result = new HashMap<>();
        try {
            vacancy selectVacancyBefore = vacancyMapper.selectVacancyBefore(vacancyCategory,id);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectVacancyBefore);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }

    @GetMapping("/user/vacancy/random")
    public Map<String,Object> selectVacancyRandom(int vacancySubject){
        Map<String,Object> result = new HashMap<>();
        try {
            List<vacancy> selectVacancyRandom = vacancyMapper.selectVacancyRandom(vacancySubject);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectVacancyRandom);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }
}
