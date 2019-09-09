package com.nwrb.eqbe.mapper;

import com.nwrb.eqbe.entity.choose;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface chooseMapper {
    //查找题目
    @Select("select * from choose where choose_id > #{id} and choose_subject=#{chooseSubject} limit 0,1")
    choose selectChoose(int id,int chooseSubject);

    @Select("select * from choose where choose_id > #{id} and choose_category = #{chooseCategory} limit 0,1")
    choose selectChooseNext(int chooseCategory,int id);

    @Select("select * from choose  where choose_id < #{id} and choose_category = #{chooseCategory} ORDER BY choose_id desc limit 0,1")
    choose selectChooseBefore(int chooseCategory,int id);

    @Select("select *  from choose where choose_subject=#{chooseSubject} order by rand() limit 2")
    List<choose> selectChooseRandom(int chooseSubject);

    @Insert("insert into choose(choose_problem,choose_a,choose_b,choose_c,choose_d,choose_e,choose_f,choose_g,choose_answer,choose_analysis,choose_category,choose_subject) values (#{chooseProblem},#{chooseA},#{chooseB},#{chooseC},#{chooseD},#{chooseE},#{chooseF},#{chooseG},#{chooseAnswer},#{chooseAnalysis},#{chooseCategory},#{chooseSubject})")
    int insertChoose(String chooseProblem,String chooseA,String chooseB,String chooseC,String chooseD,
          String chooseE,String chooseF,String chooseG,String chooseAnswer,String chooseAnalysis,int chooseCategory,int chooseSubject);

    //查找所有题目
    @Select("select * from choose where choose_subject=#{chooseSubject}")
    List<choose> selectAllChoose(int chooseSubject);
    //修改题目
    @Update("update choose set choose_problem=#{chooseProblem},choose_a=#{chooseA},choose_b=#{chooseB},choose_c=#{chooseC},choose_d=#{chooseD},choose_e=#{chooseE},choose_f=#{chooseF},choose_g=#{chooseG},choose_answer=#{chooseAnswer},choose_analysis=#{chooseAnalysis},choose_category=#{chooseCategory},choose_subject=#{chooseSubject1} where choose_subject=#{chooseSubject2}")
    int updateChooseAll(String chooseProblem,String chooseA,String chooseB,String chooseC,String chooseD,
                        String chooseE,String chooseF,String chooseG,String chooseAnswer,String chooseAnalysis,int chooseCategory,int chooseSubject1,int chooseSubject2);
    //删除题目
    @Delete("delete from choose where choose_subject=#{chooseSubject}")
    int deleteChoose(int chooseSubject);
}
