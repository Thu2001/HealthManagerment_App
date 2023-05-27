package com.example.healthmanagerment_app.model;

public class Token {
    public String message;
    public ACToken token;
    public class ACToken{
        public String accessToken;
        public String refreshToken;
    }
}

