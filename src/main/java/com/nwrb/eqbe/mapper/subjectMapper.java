package com.nwrb.eqbe.mapper;

import com.nwrb.eqbe.entity.subject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface subjectMapper {
    @Select("select * from subject")
    List<subject> selectSubjectList();

    @Select("select count(*) from subject")
    int selectSubjectCount();

    @Select("select subject_name from subject where subject_name=#{subjectName}")
    String subjectName(String subjectName);

    @Select("select ifnull(sum(subject_id),0) from subject where subject_id=#{categorySubject}")
    int subjectId(int categorySubject);

    //添加科目
    @Insert("INSERT into subject(subject_name) values (#{subjectName})")
    int insertSubjectNameResult(String subjectName);

    //修改科目
    @Update("update subject set subject_name=#{subjectName} where subject_id=#{subjectId}")
    int updateSubjectName(String subjectName,int subjectId);

    //删除科目
    @Delete("delete from subject where subject_id=#{subjectId}")
    int deleteSubject(int subjectId);
    //删除科目时删除其知识点和题目
    @Delete("delete from category where category_subject=#{subjectId}")
    int deleteCategory(int subjectId);
    @Delete("delete from choose where choose_subject=#{subjectId}")
    int deleteChoose(int subjectId);
    @Delete("delete from discuss where discuss_subject=#{subjectId}")
    int deleteDiscuss(int subjectId);
    @Delete("delete from judgment where judgment_subject=#{subjectId}")
    int deleteJudgment(int subjectId);
    @Delete("delete from vacancy where vacancy_subject=#{subjectId}")
    int deleteVacancy(int subjectId);

}
