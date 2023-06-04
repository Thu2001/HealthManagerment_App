package com.example.healthmanagerment_app.api;

import com.example.healthmanagerment_app.chitietthuoc.thongtinthuoc;
import com.example.healthmanagerment_app.model.Order;
import com.example.healthmanagerment_app.model.ResponeNotification;
import com.example.healthmanagerment_app.model.ResponePrescription;
import com.example.healthmanagerment_app.model.RpCalender;
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
    Call<RpCalender> getListNotification(@Body User user);

    @POST("api/listNoti1")
    Call<RpCalender> getListPrescriptionNoti(@Body User user);

    @POST("api/datlich")
    Call<Data> order(@Body Order order);

    @POST("api/update")
    Call<Data> uploaduser(@Body User user);
    @POST("api/getmedicune")
    Call<thongtinthuoc> chitietthuoc(@Body thongtinthuoc.Thongtinthuoc Thongtinthuoc);
    @POST("api/getListThuoc")
    Call<thongtinthuoc> getListThuoc(@Body ResponePrescription.Prescription listthuoc);

}
