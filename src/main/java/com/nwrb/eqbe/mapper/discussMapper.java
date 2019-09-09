package com.nwrb.eqbe.mapper;

import com.nwrb.eqbe.entity.discuss;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface discussMapper {

    @Select("select * from discuss where discuss_id > #{id} limit 0,1")
    discuss selectDiscuss(int id);

    @Select("select * from discuss where discuss_id > #{id} and discuss_category = #{discussCategory} limit 0,1")
    discuss selectDiscussNext(int discussCategory, int id);

    @Select("select * from discuss  where discuss_id < #{id} and discuss_Category = #{discussCategory} ORDER BY discuss_id desc limit 0,1")
    discuss selectDiscussBefore(int discussCategory,int id);

    @Select("select *  from discuss where discuss_subject=#{discussSubject} order by rand() limit 2")
    List<discuss> selectDiscussRandom(int discussSubject);

    @Insert("insert into discuss(discuss_problem,discuss_answer,discuss_analysis,discuss_category,discuss_subject) values (#{discussProblem},#{discussAnswer},#{discussAnalysis},#{discussCategory},#{discussSubject})")
    int insertDiscuss(String discussProblem,String discussAnswer,String discussAnalysis,int discussCategory,int discussSubject);
}
