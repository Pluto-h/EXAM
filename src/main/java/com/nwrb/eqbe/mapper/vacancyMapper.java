package com.nwrb.eqbe.mapper;

import com.nwrb.eqbe.entity.vacancy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface vacancyMapper {
    @Select("select * from vacancy where vacancy_id > #{id} limit 0,1")
    vacancy selectVacancy(int id);

    @Select("select * from vacancy where vacancy_id > #{id} and vacancy_category = #{vacancyCategory} limit 0,1")
    vacancy selectVacancyNext(int vacancyCategory, int id);

    @Select("select * from vacancy  where vacancy_id < #{id} and vacancy_category = #{vacancyCategory} ORDER BY vacancy_id desc limit 0,1")
    vacancy selectVacancyBefore(int vacancyCategory,int id);

    @Select("select *  from vacancy where vacancy_subject=#{vacancySubject} order by RAND() limit 2")
    List<vacancy> selectVacancyRandom(int vacancySubject);

    @Insert("insert into vacancy(vacancy_problem,vacancy_answer,vacancy_analysis,vacancy_category,vacancy_subject) values (#{vacancyProblem},#{vacancyAnswer},#{vacancyAnalysis},#{vacancyCategory},#{vacancySubject})")
    int insertVacancy(String vacancyProblem,String vacancyAnswer,String vacancyAnalysis,int vacancyCategory,int vacancySubject);
}
