package com.example.healthmanagerment_app.model;

import java.util.ArrayList;

public class Token {
    public String message;
    public ACToken token;

    public ArrayList<User> data;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ACToken getToken() {
        return token;
    }

    public void setToken(ACToken token) {
        this.token = token;
    }

    public class ACToken{
        public String accessToken;
        public String refreshToken;
    }
}

