package com.example.healthmanagerment_app.api;

import com.example.healthmanagerment_app.model.Order;
import com.example.healthmanagerment_app.model.ResponeNotification;
import com.example.healthmanagerment_app.model.ResponePrescription;
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

    @POST("api/listPre")
    Call<ResponePrescription> getListPrescription(@Body User user);

    @POST("api/listNoti")
    Call<ResponeNotification> getListNotification(@Body User user);

    @POST("api/datlich")
    Call<Data> order(@Body Order order);
}
