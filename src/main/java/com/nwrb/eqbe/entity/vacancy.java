package com.nwrb.eqbe.entity;

public class vacancy {

    private int vacancyId;
    private String vacancyProblem;
    private String vacancyAnswer;
    private String vacancyAnalysis;
    private int vacancyCategory;
    private int vacancySubject;

    public vacancy(){
        super();
    }

    public vacancy(int vacancyId,String vacancyProblem,String vacancyAnswer,String vacancyAnalysis,int vacancyCategory,int vacancySubject){
        super();
        this.vacancyId = vacancyId;
        this.vacancyProblem = vacancyProblem;
        this.vacancyAnswer = vacancyAnswer;
        this.vacancyAnalysis = vacancyAnalysis;
        this.vacancyCategory = vacancyCategory;
        this.vacancySubject = vacancySubject;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }

    public void setVacancyProblem(String vacancyProblem) {
        this.vacancyProblem = vacancyProblem;
    }

    public void setVacancyAnswer(String vacancyAnswer) {
        this.vacancyAnswer = vacancyAnswer;
    }

    public void setVacancyAnalysis(String vacancyAnalysis) {
        this.vacancyAnalysis = vacancyAnalysis;
    }

    public void setVacancyCategory(int vacancyCategory) {
        this.vacancyCategory = vacancyCategory;
    }

    public void setVacancySubject(int vacancySubject) {
        this.vacancySubject = vacancySubject;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public String getVacancyProblem() {
        return vacancyProblem;
    }

    public String getVacancyAnswer() {
        return vacancyAnswer;
    }

    public String getVacancyAnalysis() {
        return vacancyAnalysis;
    }

    public int getVacancyCategory() {
        return vacancyCategory;
    }

    public int getVacancySubject() {
        return vacancySubject;
    }

    @Override
    public String toString() {
        return "vacancy{" +
                "vacancyId=" + vacancyId +
                ", vacancyProblem='" + vacancyProblem + '\'' +
                ", vacancyAnswer='" + vacancyAnswer + '\'' +
                ", vacancyAnalysis='" + vacancyAnalysis + '\'' +
                ", vacancyCategory=" + vacancyCategory +
                ", vacancySubject=" + vacancySubject +
                '}';
    }
}
