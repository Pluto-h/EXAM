package com.nwrb.eqbe.mapper;

import com.nwrb.eqbe.entity.category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface categoryMapper {

    @Select("select * from category where category_subject=#{id}")
    List<category> selectCategoryName(int id);

    @Select("select * from category")
    List<category> selectAllCategory();

    //查询条目
    @Select("select count(*) from category")
    int selectCategoryCount();

    //插入知识点
    @Insert("insert into category(category_name,category_subject) values (#{categoryName},#{categorySubject})")
    int insertCategory(String categoryName,int categorySubject);

    //查询知识点（知识点名，id）
    @Select("select * from category where category_name=#{categoryName} and category_subject=#{categorySubject}")
    category selectCategory(String categoryName,int categorySubject);

    //修改知识点
    @Update("update category set category_name=#{categoryName},category_subject=#{categorySubject} where category_id=#{categoryId}")
    int updateCategory(String categoryName,int categorySubject,int categoryId);

    //更改知识点所属科目后，更改其题目所属科目
    @Update("update choose set choose_subject=#{categorySubject} where choose_category=#{categoryId}")
    int updateChoose(int categorySubject,int categoryId);
    @Update("update discuss set discuss_subject=#{categorySubject} where discuss_category=#{categoryId}")
    int updateDiscuss(int categorySubject,int categoryId);
    @Update("update judgment set judgment_subject=#{categorySubject} where judgment_category=#{categoryId}")
    int updateJudgment(int categorySubject,int categoryId);
    @Update("update vacancy set vacancy_subject=#{categorySubject} where vacancy_category=#{categoryId}")
    int updateVacancy(int categorySubject,int categoryId);

    //删除知识点
    @Delete("delete from category where category_id=#{categoryId}")
    int deleteCategory(int categoryId);

    //删除知识点后，删除其包含的题目
    @Delete("delete from choose where choose_category=#{categoryId}")
    int deleteChoose(int categoryId);
    @Delete("delete from discuss where discuss_category=#{categoryId}")
    int deleteDiscuss(int categoryId);
    @Delete("delete from judgment where judgment_category=#{categoryId}")
    int deleteJudgment(int categoryId);
    @Delete("delete from vacancy where vacancy_category=#{categoryId}")
    int deleteVacancy(int categoryId);
}
