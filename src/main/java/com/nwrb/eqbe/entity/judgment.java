package com.nwrb.eqbe.entity;

public class judgment {

    private int judgmentId;
    private String judgmentProblem;
    private String judgmentAnswer;
    private String judgmentAnalysis;
    private int judgmentCategory;
    private int judgmentSubject;

    public judgment(){
        super();
    }

    public judgment(int judgmentId,String judgmentProblem,String judgmentAnswer,String judgmentAnalysis,int judgmentCategory,int judgmentSubject){
        super();
        this.judgmentId = judgmentId;
        this.judgmentProblem = judgmentProblem;
        this.judgmentAnswer = judgmentAnswer;
        this.judgmentAnalysis = judgmentAnalysis;
        this.judgmentCategory = judgmentCategory;
        this.judgmentCategory = judgmentSubject;
    }

    public int getJudgmentId() {
        return judgmentId;
    }

    public String getJudgmentProblem() {
        return judgmentProblem;
    }

    public String getJudgmentAnswer() {
        return judgmentAnswer;
    }

    public String getJudgmentAnalysis() {
        return judgmentAnalysis;
    }

    public int getJudgmentCategory() {
        return judgmentCategory;
    }

    public int getJudgmentSubject() {
        return judgmentSubject;
    }

    public void setJudgmentId(int judgmentId) {
        this.judgmentId = judgmentId;
    }

    public void setJudgmentProblem(String judgmentProblem) {
        this.judgmentProblem = judgmentProblem;
    }

    public void setJudgmentAnswer(String judgmentAnswer) {
        this.judgmentAnswer = judgmentAnswer;
    }

    public void setJudgmentAnalysis(String judgmentAnalysis) {
        this.judgmentAnalysis = judgmentAnalysis;
    }

    public void setJudgmentCategory(int judgmentCategory) {
        this.judgmentCategory = judgmentCategory;
    }

    public void setJudgmentSubject(int judgmentSubject) {
        this.judgmentSubject = judgmentSubject;
    }

    @Override
    public String toString() {
        return "judgment{" +
                "judgmentId=" + judgmentId +
                ", judgmentProblem='" + judgmentProblem + '\'' +
                ", judgmentAnswer='" + judgmentAnswer + '\'' +
                ", judgmentAnalysis='" + judgmentAnalysis + '\'' +
                ", judgmentCategory=" + judgmentCategory +
                ", judgmentSubject=" + judgmentSubject +
                '}';
    }
}
