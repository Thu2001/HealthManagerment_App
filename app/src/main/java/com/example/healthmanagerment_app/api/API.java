package com.example.healthmanagerment_app.api;

import com.example.healthmanagerment_app.model.Token;
import com.example.healthmanagerment_app.model.User;
import com.example.healthmanagerment_app.model.Data;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
    @POST("login")
    Call<Token> login(@Body User user);
    @POST("api/register")
    Call<Data> registerUser(@Body User user);

    @POST("api/user")
    Call<Data> getInfo(@Body User user);
}
