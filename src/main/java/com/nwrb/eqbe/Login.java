package com.nwrb.eqbe;

import com.nwrb.eqbe.mapper.accountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@EnableAutoConfiguration
public class Login {
    @Autowired
    private accountMapper accountMapper;

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String login() {
        return "/login";
    }

    /**
     *@描述   用户登录
     *@参数  [accountNumber, accountPassword, session]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/10
     *@修改人和其它信息
     */
    @GetMapping("/user")
    @ResponseBody
    public Map<String,Object> login(@RequestParam String accountNumber, @RequestParam String accountPassword, HttpSession session) {
        Map<String,Object> result = new HashMap<>();
        try {
            int accountId = accountMapper.login(accountNumber,accountPassword);
            if (accountId==0){
                result.put("code",101);
                result.put("error"," 对象不存在，或者密码不正确。");
                return result;
            }
            session.setAttribute("accountId",accountId);
            result.put("code",200);
            result.put("success","身份验证成功");
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器遇到错误");
            return result;
        }
    }

    /**
     *@描述   注册用户
     *@参数  [accountNumber, accountPassword, accountPassword1]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/10
     *@修改人和其它信息
     */
    @PostMapping("/user/login")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Map<String,Object> registered(@RequestParam String accountNumber,@RequestParam String accountPassword,
                              @RequestParam String accountPassword1) {
        Map<String,Object> result = new HashMap<>();
        try {
            if (accountPassword.equals(accountPassword1)){
                String selectAccountNumber = accountMapper.selectAccountNumber(accountNumber);
                if (selectAccountNumber==null){
                    accountMapper.insertAccount(accountNumber,accountPassword,1);
                    int selectAccountId = accountMapper.selectAccountId(accountNumber);
                    accountMapper.insertStudentId(selectAccountId);
                    result.put("code",200);
                    result.put("success","用户创建成功");
                    return result;
                }
                result.put("code",202);
                result.put("error","用户名已经被占用");
                return result;
            }
            result.put("code",253);
            result.put("error","两次密码不一致");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.put("code",500);
            result.put("error","服务器遇到错误");
            return result;
        }
    }

    /**
     *@描述   管理员登录
     *@参数  [accountNumber, accountPassword, session]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/11
     *@修改人和其它信息
     */
    @GetMapping("/admin/login")
    @ResponseBody
    public Map<String,Object> adminLogin(@RequestParam String accountNumber, @RequestParam String accountPassword, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        try {
            int adminAccountId = accountMapper.login(accountNumber, accountPassword);
            if (adminAccountId == 0) {
                result.put("code", 101);
                result.put("error", " 对象不存在，或者密码不正确。");
                return result;
            } else {
                int accountPermissions = accountMapper.accountPermissions(adminAccountId);
                if (accountPermissions == 2) {
                    session.setAttribute("adminAccountId", adminAccountId);
                    result.put("code", 200);
                    result.put("success", "登陆成功");
                    return result;
                }else {
                    result.put("code", 401);
                    result.put("error", "权限不足，无法登陆！");
                    return result;
                }
            }
        } catch (Exception e) {
            result.put("code", 500);
            result.put("error", "服务器遇到错误");
            return result;
        }
    }
}