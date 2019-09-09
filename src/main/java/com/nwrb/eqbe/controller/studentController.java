package com.nwrb.eqbe.controller;


import com.nwrb.eqbe.entity.student;
import com.nwrb.eqbe.mapper.studentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class studentController {

    @Autowired
    private studentMapper studentMapper;

    /**
     *@描述   查询用户信息
     *@参数  [session]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/10
     *@修改人和其它信息
     */
    @GetMapping("/user/user")
    public Map<String,Object> person(HttpSession session){
        Map<String,Object> result = new HashMap<>();
        try{
            if (session.getAttribute("accountId")==null){
                result.put("code",401);
                result.put("error","用户未登陆");
                return result;
            }
            int accountId = (int)session.getAttribute("accountId");
            student studentList = studentMapper.selectStudentList(accountId);
            result.put("code",200);
            result.put("success","查询成功");
            result.put("data",studentList);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }

    /**
     *@描述   管理员查询用户资料
     *@参数  [accountId]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/11
     *@修改人和其它信息
     */
    @GetMapping("/admin/user")
    public Map<String,Object> student(int accountId,HttpSession session){
        Map<String,Object> result = new HashMap<>();
        try{
            if(session.getAttribute("adminAccountId")==null){
                result.put("code",401);
                result.put("error","权限不足，无法查询！");
                return result;
            }
            student studentList = studentMapper.selectStudentList(accountId);
            result.put("code",200);
            result.put("success","查询成功");
            result.put("data",studentList);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }
}
