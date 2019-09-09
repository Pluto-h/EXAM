package com.nwrb.eqbe.mapper;

import com.nwrb.eqbe.entity.judgment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface judgmentMapper {

    @Select("select * from judgment where judgment_id > #{id} limit 0,1")
    judgment selectJudgment(int id);

    @Select("select * from judgment where judgment_id > #{id} and judgment_category = #{judgmentCategory} limit 0,1")
    judgment selectJudgmentNext(int judgmentCategory, int id);

    @Select("select * from judgment  where judgment_id < #{id} and judgment_category = #{judgmentCategory} ORDER BY judgment_id desc limit 0,1")
    judgment selectJudgmentBefore(int judgmentCategory,int id);

    @Select("select *  from judgment where judgment_subject=#{judgmentSubject} order by RAND() limit 2")
    List<judgment> selectJudgmentRandom(int judgmentSubject);

    @Insert("insert into judgment(judgment_problem,judgment_answer,judgment_analysis,judgment_category,judgment_subject) values (#{judgmentProblem},#{judgmentAnswer},#{judgmentAnalysis},#{judgmentCategory},#{judgmentSubject})")
    int insertJudgment(String judgmentProblem,String judgmentAnswer,String judgmentAnalysis,int judgmentCategory,int judgmentSubject);
}

