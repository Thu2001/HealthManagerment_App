package com.example.healthmanagerment_app.api;

import com.example.healthmanagerment_app.model.data;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface API {
    @GET("api/loaixe")
    Call<data> getdata();
}
