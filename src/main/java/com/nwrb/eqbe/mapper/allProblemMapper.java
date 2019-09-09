package com.nwrb.eqbe.mapper;

import com.nwrb.eqbe.entity.choose;
import com.nwrb.eqbe.entity.discuss;
import com.nwrb.eqbe.entity.judgment;
import com.nwrb.eqbe.entity.vacancy;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface allProblemMapper {
    @Select("select *  from choose where choose_subject=#{id} order by rand() limit 2")
    List<choose> selectChoose(int id);
    @Select("select *  from vacancy where vacancy_subject=#{id} order by rand() limit 2")
    List<vacancy> selectVacancy(int id);
    @Select("select *  from judgment where judgment_subject=#{id} order by rand() limit 2")
    List<judgment> selectJudgment(int id);
    @Select("select *  from discuss where discuss_subject=#{id} order by rand() limit 2")
    List<discuss> selectDiscuss(int id);
}
