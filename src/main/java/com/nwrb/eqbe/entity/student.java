package com.nwrb.eqbe.entity;

public class student {
    private int studentId;//id
    private String studentName;//学生姓名
    private String studentGender;//学生性别
    private String studentSchool;//学生学校
    private int studentStudentid;//学生学号
    private String studentAddress;//学生地址
    private int studentPhone;//学生手机号
    private String studentEmail;//学生邮箱
    private int studentAge;//学生年龄
    private int studentQq;//学生QQ
    private String studentWechat;//学生微信

    public student(){ super(); }

    public student(int studentId,String studentName,String studentGender,String studentSchool,int studentStudentid
    ,String studentAddress,int studentAge,int studentQq,String studentWechat,String studentEmail,int studentPhone){
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentSchool = studentSchool;
        this.studentStudentid = studentStudentid;
        this.studentAddress = studentAddress;
        this.studentPhone = studentPhone;
        this.studentEmail = studentEmail;
        this.studentAge = studentAge;
        this.studentQq = studentQq;
        this.studentWechat = studentWechat;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public String getStudentSchool() {
        return studentSchool;
    }

    public int getStudentStudentid() {
        return studentStudentid;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public int getStudentPhone() {
        return studentPhone;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public int getStudentQq() {
        return studentQq;
    }

    public String getStudentWechat() {
        return studentWechat;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public void setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool;
    }

    public void setStudentStudentid(int studentStudentid) {
        this.studentStudentid = studentStudentid;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public void setStudentPhone(int studentPhone) {
        this.studentPhone = studentPhone;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public void setStudentQq(int studentQq) {
        this.studentQq = studentQq;
    }

    public void setStudentWechat(String studentWechat) {
        this.studentWechat = studentWechat;
    }

    @Override
    public String toString() {
        return "student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentGender='" + studentGender + '\'' +
                ", studentSchool='" + studentSchool + '\'' +
                ", studentStudentid=" + studentStudentid +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentPhone=" + studentPhone +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentAge=" + studentAge +
                ", studentQq=" + studentQq +
                ", studentWechat='" + studentWechat + '\'' +
                '}';
    }
}
