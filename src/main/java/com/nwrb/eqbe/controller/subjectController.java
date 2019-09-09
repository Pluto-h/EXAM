package com.nwrb.eqbe.controller;

import com.nwrb.eqbe.entity.subject;
import com.nwrb.eqbe.mapper.subjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class subjectController {
    @Autowired
    private subjectMapper subjectMapper;

    /**
     *@描述   获取科目
     *@参数  []
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/10
     *@修改人和其它信息
     */
    @GetMapping("/user/subject")
    public Map<String,Object> index(){
        Map<String,Object> result = new HashMap<>();
        try {
            List<subject> SubjectList = subjectMapper.selectSubjectList();
            result.put("code",200);
            result.put("success","获取成功");
            result.put("data",SubjectList);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }

    /**
     *@描述   管理员添加科目
     *@参数  [subjectName, session]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/12
     *@修改人和其它信息
     */
    @PostMapping("/admin/subject")
    public Map<String,Object> insertSubject(String subjectName, HttpSession session){
        Map<String,Object> result = new HashMap<>();
        try {
            System.out.println(subjectName);
            if(session.getAttribute("adminAccountId")==null){
                result.put("code",401);
                result.put("error","权限不足，无法添加科目！");
                return result;
            }else {
                if (subjectMapper.subjectName(subjectName)==null){
                    subjectMapper.insertSubjectNameResult(subjectName);
                    result.put("code",200);
                    result.put("success","添加成功");
                    return result;
                }else {
                    result.put("code",202);
                    result.put("error","科目已存在");
                    return result;
                }
            }
        }catch (Exception e){
            result.put("code",500);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.put("error","服务器错误");
            return result;
        }
    }

    /**
     *@描述   管理员修改科目
     *@参数  [subjectId, subjectName, session]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/13
     *@修改人和其它信息
     */
    @PutMapping("/admin/subject")
    public Map<String,Object> alterSubject(int subjectId,String subjectName,HttpSession session){
        Map<String,Object> result = new HashMap<>();
        try {
            if(session.getAttribute("adminAccountId")==null){
                result.put("code",401);
                result.put("error","权限不足，无法添加科目！");
                return result;
            }else {
                if(subjectMapper.subjectId(subjectId)==0){
                    result.put("code",203);
                    result.put("error","该科目不存在");
                    return result;
                }else {
                    if (subjectMapper.subjectName(subjectName)==null){
                        subjectMapper.updateSubjectName(subjectName,subjectId);
                        result.put("code",200);
                        result.put("success","修改成功");
                        return result;
                    }else {
                        result.put("code",202);
                        result.put("error","科目名已存在");
                        return result;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }

    /**
     *@描述   管理员获取科目
     *@参数  [session]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/17
     *@修改人和其它信息
     */
    @GetMapping("/admin/subject")
    public Map<String,Object> adminGetSubject(HttpSession session){
        Map<String,Object> result = new HashMap<>();
        try {
            if(session.getAttribute("adminAccountId")==null){
                result.put("code",401);
                result.put("error","权限不足，无法获取科目！");
                return result;
            }else {
                List<subject> getSubject = subjectMapper.selectSubjectList();
                result.put("code",200);
                result.put("success","查询成功");
                result.put("subject",getSubject);
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("code",500);
            result.put("error","服务器错误");
            return result;
        }
    }

    /**
     *@描述   管理员删除科目
     *@参数  [subjectId, session]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/25
     *@修改人和其它信息
     */
    @DeleteMapping("/admin/subject")
    public Map<String,Object> adminDeleteSubject(int subjectId,HttpSession session){
        Map<String,Object> result = new HashMap<>();
        try {
            if(session.getAttribute("adminAccountId")==null){
                result.put("code",401);
                result.put("error","权限不足，无法获取科目！");
                return result;
            }else {
                if(subjectMapper.subjectId(subjectId)==0){
                    result.put("code",203);
                    result.put("error","该科目不存在");
                    return result;
                }else {
                    subjectMapper.deleteSubject(subjectId);
                    subjectMapper.deleteCategory(subjectId);
                    subjectMapper.deleteChoose(subjectId);
                    subjectMapper.deleteDiscuss(subjectId);
                    subjectMapper.deleteJudgment(subjectId);
                    subjectMapper.deleteVacancy(subjectId);
                    result.put("code","200");
                    result.put("success","删除成功");
                    return result;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.put("code","500");
            result.put("error","服务器繁忙");
            return result;
        }
    }
}
