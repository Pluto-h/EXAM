package com.nwrb.eqbe.mapper;

import com.nwrb.eqbe.entity.student;
import org.apache.ibatis.annotations.Select;


public interface studentMapper {
    @Select("SELECT * FROM student where student_id=#{accountId}")
    student selectStudentList(int accountId);
}
