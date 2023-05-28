package com.example.healthmanagerment_app.model;

import java.util.ArrayList;

public class Data {
    public String message;
    public ArrayList<User> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<User> getData() {
        return data;
    }

    public void setData(ArrayList<User> data) {
        this.data = data;
    }
}

