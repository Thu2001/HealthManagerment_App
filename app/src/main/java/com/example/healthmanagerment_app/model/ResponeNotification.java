package com.example.healthmanagerment_app.model;

import java.util.ArrayList;

public class ResponeNotification {
    public String message;
    public ArrayList<Notification> data;
    public class Notification{
        public int id;
        public String idNoti;
        public String content;
        public String userCode;
        public String name;
    }
}
