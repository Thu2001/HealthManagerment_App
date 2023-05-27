package com.example.healthmanagerment_app.api;

import com.example.healthmanagerment_app.model.Token;
import com.example.healthmanagerment_app.model.User;
import com.example.healthmanagerment_app.model.data;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {
    @POST("login")
    Call<Token> login(@Body User user);
    @POST("api/register")
    Call<data> registerUser(@Body User user);
}
