package com.example.healthmanagerment_app.login;

import static androidx.core.content.ContextCompat.getSystemService;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.api.API;
import com.example.healthmanagerment_app.api.RetrofitClient;
import com.example.healthmanagerment_app.api.ServerJWT;
import com.example.healthmanagerment_app.mainScreen.mainScreen;
import com.example.healthmanagerment_app.model.Token;
import com.example.healthmanagerment_app.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Button login = (Button) view.findViewById(R.id.button123);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_login2_to_mainScreen);
                User user = new User();
                user.setAccount("1");
                user.setPassword("1");
                API methods = ServerJWT.getRetrofit().create(API.class);
                Call<Token> call = methods.login(user);
                call.enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {

                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {

                    }
                });
            }
        });
        TextView register = (TextView) view.findViewById(R.id.register_user);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_login2_to_register);
            }
        });

        return view;
    }


    public Boolean Login(String Acc,String Pas, View view){
        Boolean check =false;

        return false;
    }
}