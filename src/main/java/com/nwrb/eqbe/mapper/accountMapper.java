package com.nwrb.eqbe.mapper;

import com.nwrb.eqbe.entity.account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface accountMapper {
    //查询所有账号
    @Select("SELECT account_id,account_number FROM account where account_permissions=1")
    List<account> selectAccountList();
    //查询用户是否存在
    @Select("select ifnull(sum(account_id),0) from account where account_Number=#{accountNumber} and account_password=#{accountPassword}")
    int login(String accountNumber,String accountPassword);
    //查询用户权限
    @Select("select account_permissions from account where account_id=#{adminAccountId}")
    int accountPermissions(int adminAccountId);
    //查询用户名
    @Select("select account_number from account where account_Number=#{accountNumber}")
    String selectAccountNumber(String accountNumber);
    //查询账号id
    @Select("select account_id from account where account_Number=#{accountNumber}")
    int selectAccountId(String accountNumber);
    //插入学生id
    @Insert("insert into student(student_id) values (#{accountId})")
    int insertStudentId(int accountId);
    //更改用户密码
    @Update("Update account set account_password=#{accountPassword} where account_id=#{accountId}")
    int updateAccountPassword(String accountPassword,int accountId);
    //更改权限
    @Update("update account set account_permissions=#{accountPermissions} where account_id=#{accountId}")
    int updateAccountpermissions(int accountPermissions,int accountId);
    //添加用户
    @Insert("INSERT INTO account(account_number,account_password,account_permissions) VALUES (#{accountNumber},#{accountPassword},#{accountPermissions})")
    int insertAccount(String accountNumber,String accountPassword,int accountPermissions);
}
