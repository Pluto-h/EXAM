package com.nwrb.eqbe.controller;

import com.nwrb.eqbe.entity.choose;
import com.nwrb.eqbe.mapper.chooseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class chooseController {

    @Autowired
    private chooseMapper chooseMapper;

    /**
     *@描述   根据科目和id查询题目(顺序，一题)
     *@参数  [id, chooseSubject]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/10
     *@修改人和其它信息
     */
    @GetMapping("/user/choose/all")
    public Map<String, Object> choose(int id,int chooseSubject){
        Map<String,Object> result = new HashMap<>();
        try {
            choose selectChoose = chooseMapper.selectChoose(id,chooseSubject);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectChoose);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器繁忙");
            return result;
        }
    }

    /**
     *@描述   根据知识点和id查询题目(顺序，一题，查询下一题)
     *@参数  [chooseCategory, id]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/10
     *@修改人和其它信息
     */
    @GetMapping("/user/choose/next")
    public Map<String, Object> selectChooseNext(int chooseCategory, int id){
        Map<String,Object> result = new HashMap<>();
        try {
            choose selectChooseNext = chooseMapper.selectChooseNext(chooseCategory,id);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectChooseNext);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器繁忙");
            return result;
        }
    }

    /**
     *@描述   根据知识点和id查询题目(顺序，一题，查询上一题)
     *@参数  [chooseCategory, id]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/10
     *@修改人和其它信息
     */
    @GetMapping("/user/choose/before")
    public Map<String, Object> selectChooseBefore(int chooseCategory, int id){
        Map<String, Object> result = new HashMap<>();
        try {
            choose selectChooseBefore = chooseMapper.selectChooseBefore(chooseCategory,id);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectChooseBefore);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器繁忙");
            return result;
        }
    }

    /**
     *@描述   根据科目随机获取题目
     *@参数  [chooseSubject]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/10
     *@修改人和其它信息
     */
    @GetMapping("/user/choose/random")
    public Map<String,Object> selectChooseRandom(int chooseSubject){
        Map<String,Object> result = new HashMap<>();
        try {
            List<choose> selectChooseRandom = chooseMapper.selectChooseRandom(chooseSubject);
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",selectChooseRandom);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器繁忙");
            return result;
        }
    }
    /**
     *@描述   管理员获取题目
     *@参数  [chooseSubject, session]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/25
     *@修改人和其它信息
     */
    @GetMapping("/admin/choose")
    public Map<String,Object> adminGetChoose(int chooseSubject, HttpSession session){
        Map<String,Object> result = new HashMap<>();
        try {
            if(session.getAttribute("adminAccountId")==null){
                result.put("code",401);
                result.put("error","权限不足，无法获取题目！");
                return result;
            }else {
                List<choose> chooseList = chooseMapper.selectAllChoose(chooseSubject);
                result.put("code",200);
                result.put("success","获取成功");
                result.put("chooseList",chooseList);
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("code",500);
            result.put("error","服务器繁忙");
            return result;
        }
    }
    
    /**
     *@描述
     *@参数  [chooseProblem, chooseA, chooseB, chooseC, chooseD, chooseE, chooseF, chooseG, chooseAnswer, chooseAnalysis, chooseCategory, chooseSubject, session]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/9/9
     *@修改人和其它信息
     */
    @PostMapping("/admin/choose")
    public Map<String,Object> adminAlterChoose(String chooseProblem,String chooseA,String chooseB,String chooseC,String chooseD,
                                               String chooseE,String chooseF,String chooseG,String chooseAnswer,String chooseAnalysis,int chooseCategory,int chooseSubject, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (session.getAttribute("adminAccountId") == null) {
                result.put("code", 401);
                result.put("error", "权限不足，无法修改题目！");
                return result;
            } else {
                chooseMapper.updateChooseAll(chooseProblem, chooseA, chooseB, chooseC, chooseD, chooseE, chooseF, chooseG, chooseAnswer, chooseAnalysis, chooseCategory, chooseSubject, chooseSubject);
                result.put("code", 200);
                result.put("success", "修改成功");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 500);
            result.put("error", "服务器繁忙");
            return result;
        }
    }
}
