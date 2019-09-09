package com.nwrb.eqbe.controller;

import com.nwrb.eqbe.entity.category;
import com.nwrb.eqbe.mapper.categoryMapper;
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
public class categoryController {

    @Autowired
    private categoryMapper categoryMapper;
    @Autowired
    private subjectMapper subjectMapper;

    /**
     *@描述   根据科目查询知识点
     *@参数  [id]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/10
     *@修改人和其它信息
     */
    @GetMapping("/user/categories")
    public Map<String,Object> firstPage(int id){
        Map<String,Object> result = new HashMap<>();
        try {
            List<category> selectCategoryName = categoryMapper.selectCategoryName(id);
            result.put("code",200);
            result.put("success","查询成功");
            result.put("data",selectCategoryName);
            return result;
        }catch (Exception e){
            result.put("code",500);
            result.put("error","服务器繁忙");
            return result;
        }
    }


    /**
     *@描述   管理员添加知识点
     *@参数  [categoryName, categorySubject, session]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/12
     *@修改人和其它信息
     */
    @PostMapping("/admin/categories")
    public Map<String,Object> insertSubject(String categoryName,int categorySubject, HttpSession session){
        Map<String,Object> result = new HashMap<>();
        try {
            if(session.getAttribute("adminAccountId")==null){
                result.put("code",401);
                result.put("error","权限不足，无法添加知识点！");
                return result;
            }else {
                if(subjectMapper.subjectId(categorySubject)==0){
                    result.put("code",203);
                    result.put("error","科目不存在！");
                    return result;
                }else {
                    if (categoryMapper.selectCategory(categoryName,categorySubject)==null){
                        categoryMapper.insertCategory(categoryName,categorySubject);
                        result.put("code",200);
                        result.put("success","添加成功");
                        return result;
                    }else {
                        result.put("code",202);
                        result.put("error","知识点已存在");
                        return result;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.put("code",500);
            result.put("error","服务器繁忙");
            return result;
        }
    }

    /**
     *@描述   管理员获取知识点（根据科目）
     *@参数  [id, session]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/17
     *@修改人和其它信息
     */
    @GetMapping("/admin/categories")
    public Map<String,Object> adminGetCategory(int id,HttpSession session){
        Map<String,Object> result = new HashMap<>();
        try {
            if(session.getAttribute("adminAccountId")==null){
                result.put("code",401);
                result.put("error","权限不足，无法获取知识点！");
                return result;
            }else {
                List<category> getCategory = categoryMapper.selectCategoryName(id);
                result.put("code",200);
                result.put("success","获取知识点成功");
                result.put("category",getCategory);
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
     *@描述   更改知识点
     *@参数  [categoryId, categorySubject, categoryName, session]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/19
     *@修改人和其它信息
     */
    @PutMapping("/admin/categories")
    public Map<String,Object> adminAlterCategory(int categoryId,int categorySubject,String categoryName,HttpSession session){
        Map<String,Object> result = new HashMap<>();
        try {
            if(session.getAttribute("adminAccountId")==null){
                result.put("code",401);
                result.put("error","权限不足，无法更改知识点！");
                return result;
            }else {
                if (categoryMapper.selectCategory(categoryName,categorySubject)==null){
                    result.put("code",202);
                    result.put("error","知识点不存在");
                    return result;
                }else {
                    categoryMapper.updateCategory(categoryName,categorySubject,categoryId);
                    categoryMapper.updateChoose(categorySubject,categoryId);
                    categoryMapper.updateDiscuss(categorySubject,categoryId);
                    categoryMapper.updateJudgment(categorySubject,categoryId);
                    categoryMapper.updateVacancy(categorySubject,categoryId);
                    result.put("code",200);
                    result.put("success","修改成功");
                    return result;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.put("code",500);
            result.put("error","服务器繁忙");
            return result;
        }
    }


    /**
     *@描述   删除知识点
     *@参数  [categoryId, session]
     *@返回值  java.util.Map<java.lang.String,java.lang.Object>
     *@创建人  胡满意
     *@创建时间  2019/6/19
     *@修改人和其它信息
     */
    @DeleteMapping("/admin/categories")
    public Map<String,Object> adminDeleteCategory(int categoryId,HttpSession session){
        Map<String,Object> result = new HashMap<>();
        try {
            if(session.getAttribute("adminAccountId")==null){
                result.put("code",401);
                result.put("error","权限不足，无法删除知识点！");
                return result;
            }else {
                if(categoryMapper.selectCategoryName(categoryId)==null){
                    result.put("code",202);
                    result.put("error","知识点不存在");
                    return result;
                }else {
                    categoryMapper.deleteCategory(categoryId);
                    categoryMapper.deleteCategory(categoryId);
                    categoryMapper.deleteDiscuss(categoryId);
                    categoryMapper.deleteJudgment(categoryId);
                    categoryMapper.deleteVacancy(categoryId);
                    result.put("code",200);
                    result.put("success","删除成功");
                    return result;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.put("code",500);
            result.put("error","服务器繁忙");
            return result;
        }
    }
}
