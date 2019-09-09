package com.nwrb.eqbe.controller;


import com.nwrb.eqbe.entity.choose;
import com.nwrb.eqbe.entity.discuss;
import com.nwrb.eqbe.entity.judgment;
import com.nwrb.eqbe.entity.vacancy;
import com.nwrb.eqbe.mapper.allProblemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class allProblemController {
    @Autowired
    private allProblemMapper allProblemMapper;

    /**
     *@描述   根据科目获取题目
     *@参数  [id]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/10
     *@修改人和其它信息
     */
    @GetMapping("/user/problems")
    public Map<String,Object> selectAllProblem(int id){
        Map<String,Object> result = new HashMap<>();
        try {
            List<choose> selectChoose = allProblemMapper.selectChoose(id);
            List<vacancy> selectVacancy = allProblemMapper.selectVacancy(id);
            List<judgment> selectJudgment = allProblemMapper.selectJudgment(id);
            List<discuss> selectDiscuss = allProblemMapper.selectDiscuss(id);
            result.put("code",200);
            result.put("success","查询成功时");
            result.put("选择题",selectChoose);
            result.put("填空题",selectVacancy);
            result.put("判断题",selectJudgment);
            result.put("简答题",selectDiscuss);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器繁忙");
            return result;
        }
    }
}
