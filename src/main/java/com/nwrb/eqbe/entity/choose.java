package com.nwrb.eqbe.entity;

public class choose {
    private int chooseId;
    private String chooseProblem;
    private  String chooseA;
    private String chooseB;
    private String chooseC;
    private String chooseD;
    private String chooseE;
    private String chooseF;
    private String chooseG;
    private String chooseAnswer;
    private String chooseAnalysis;
    private int chooseCategory;
    private int chooseSubject;

    public choose(){
        super();
    }

    public choose(int chooseId,String chooseA,String chooseB,String chooseC,String chooseD,String chooseE,
                  String chooseF,String chooseG,String chooseAnswer,String chooseAnalysis,int chooseCategory,int chooseSubject){
        super();
        this.chooseId=chooseId;
        this.chooseA = chooseA;
        this.chooseB = chooseB;
        this.chooseC = chooseC;
        this.chooseD = chooseD;
        this.chooseE = chooseE;
        this.chooseF = chooseF;
        this.chooseG = chooseG;
        this.chooseAnswer = chooseAnswer;
        this.chooseAnalysis = chooseAnalysis;
        this.chooseCategory = chooseCategory;
        this.chooseSubject=chooseSubject;
    }

    public int getChooseId() {
        return chooseId;
    }

    public String getChooseProblem() {
        return chooseProblem;
    }

    public String getChooseA() {
        return chooseA;
    }

    public String getChooseB() {
        return chooseB;
    }

    public String getChooseC() {
        return chooseC;
    }

    public String getChooseD() {
        return chooseD;
    }

    public String getChooseE() {
        return chooseE;
    }

    public String getChooseF() {
        return chooseF;
    }

    public String getChooseG() {
        return chooseG;
    }

    public String getChooseAnswer() {
        return chooseAnswer;
    }

    public String getChooseAnalysis() {
        return chooseAnalysis;
    }

    public int getChooseCategory() {
        return chooseCategory;
    }

    public int getChooseSubject() {
        return chooseSubject;
    }

    public void setChooseId(int chooseId) {
        this.chooseId = chooseId;
    }

    public void setChooseProblem(String chooseProblem) {
        this.chooseProblem = chooseProblem;
    }

    public void setChooseA(String chooseA) {
        this.chooseA = chooseA;
    }

    public void setChooseB(String chooseB) {
        this.chooseB = chooseB;
    }

    public void setChooseC(String chooseC) {
        this.chooseC = chooseC;
    }

    public void setChooseD(String chooseD) {
        this.chooseD = chooseD;
    }

    public void setChooseE(String chooseE) {
        this.chooseE = chooseE;
    }

    public void setChooseF(String chooseF) {
        this.chooseF = chooseF;
    }

    public void setChooseG(String chooseG) {
        this.chooseG = chooseG;
    }

    public void setChooseAnswer(String chooseAnswer) {
        this.chooseAnswer = chooseAnswer;
    }

    public void setChooseAnalysis(String chooseAnalysis) {
        this.chooseAnalysis = chooseAnalysis;
    }

    public void setChooseCategory(int chooseCategory) {
        this.chooseCategory = chooseCategory;
    }

    public void setChooseSubject(int chooseSubject) {
        this.chooseSubject = chooseSubject;
    }

    @Override
    public String toString() {
        return "choose{" +
                "chooseId=" + chooseId +
                ", chooseProblem='" + chooseProblem + '\'' +
                ", chooseA='" + chooseA + '\'' +
                ", chooseB='" + chooseB + '\'' +
                ", chooseC='" + chooseC + '\'' +
                ", chooseD='" + chooseD + '\'' +
                ", chooseE='" + chooseE + '\'' +
                ", chooseF='" + chooseF + '\'' +
                ", chooseG='" + chooseG + '\'' +
                ", chooseAnswer='" + chooseAnswer + '\'' +
                ", chooseAnalysis='" + chooseAnalysis + '\'' +
                ", chooseCategory=" + chooseCategory +
                ", chooseSubject=" + chooseSubject +
                '}';
    }
}

