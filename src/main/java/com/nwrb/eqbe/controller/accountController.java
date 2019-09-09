package com.nwrb.eqbe.controller;

import com.nwrb.eqbe.entity.account;
import com.nwrb.eqbe.mapper.accountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class accountController {
    @Autowired
    private accountMapper accountMapper;

    /**
     *@描述   查询所有用户
     *@参数  [session]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/11
     *@修改人和其它信息
     */
    @GetMapping("/admin/accounts")
    public Map<String,Object> person(HttpSession session){
        Map<String,Object> result = new HashMap<>();
        try{
            if(session.getAttribute("adminAccountId")==null){
                result.put("code",401);
                result.put("error","权限不足，无法查询！");
                return result;
            }else {
                List<account> accountList = accountMapper.selectAccountList();
                result.put("code",200);
                result.put("success","查询成功");
                result.put("data",accountList);
                return result;
            }
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器繁忙！");
            return result;
        }
    }
}
