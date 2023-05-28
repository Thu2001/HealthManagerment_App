package com.example.healthmanagerment_app.api;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerJWT {
    private static Retrofit retrofit;
    private static String  Base_Url="http://192.168.5.70:5000/";
    public static String getBase_Url(){
        return Base_Url;
    }
    public void setBase_Url(String base_Url){
        Base_Url=base_Url;

    }
    public static Retrofit getRetrofit(){
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .client(new OkHttpClient.Builder().build())
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                    .build();
        }
        return retrofit;
    }
}
