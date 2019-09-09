package com.nwrb.eqbe.entity;

public class discuss {

    private int discussId;
    private String discussProblem;
    private String discussAnswer;
    private String discussAnalysis;
    private int discussCategory;
    private int discussSubject;

    public discuss(){
        super();
    }

    public discuss(int discussId,String discussProblem,String discussAnswer,String discussAnalysis,int discussCategory,int discussSubject){
        super();
        this.discussId = discussId;
        this.discussProblem = discussProblem;
        this.discussAnswer = discussAnswer;
        this.discussAnalysis = discussAnalysis;
        this.discussCategory = discussCategory;
        this.discussSubject = discussSubject;
    }

    public int getDiscussId() {
        return discussId;
    }

    public String getDiscussProblem() {
        return discussProblem;
    }

    public String getDiscussAnswer() {
        return discussAnswer;
    }

    public String getDiscussAnalysis() {
        return discussAnalysis;
    }

    public int getDiscussCategory() {
        return discussCategory;
    }

    public int getDiscussSubject() {
        return discussSubject;
    }

    public void setDiscussId(int discussId) {
        this.discussId = discussId;
    }

    public void setDiscussProblem(String discussProblem) {
        this.discussProblem = discussProblem;
    }

    public void setDiscussAnswer(String discussAnswer) {
        this.discussAnswer = discussAnswer;
    }

    public void setDiscussAnalysis(String discussAnalysis) {
        this.discussAnalysis = discussAnalysis;
    }

    public void setDiscussCategory(int discussCategory) {
        this.discussCategory = discussCategory;
    }

    public void setDiscussSubject(int discussSubject) {
        this.discussSubject = discussSubject;
    }

    @Override
    public String toString() {
        return "discuss{" +
                "discussId=" + discussId +
                ", discussProblem='" + discussProblem + '\'' +
                ", discussAnswer='" + discussAnswer + '\'' +
                ", discussAnalysis='" + discussAnalysis + '\'' +
                ", discussCategory=" + discussCategory +
                ", discussSubject=" + discussSubject +
                '}';
    }
}
