package com.example.healthmanagerment_app.model;

public class Order {
    String putDate,faculty,codeUser;

    public String getUserCode() {
        return codeUser;
    }

    public void setUserCode(String userCode) {
        this.codeUser = userCode;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getPutDate() {
        return putDate;
    }

    public void setPutDate(String putDate) {
        this.putDate = putDate;
    }
}
