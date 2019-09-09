package com.nwrb.eqbe.entity;

public class category {
    private int categoryId;
    private String categoryName;
    private int categorySubject;

    public category(){
        super();
    }

    public category(int categoryId,String categoryName,int categorySubject){
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categorySubject = categorySubject;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategorySubject() {
        return categorySubject;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategorySubject(int categorySubject) {
        this.categorySubject = categorySubject;
    }

    @Override
    public String toString() {
        return "category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categorySubject=" + categorySubject +
                '}';
    }
}
