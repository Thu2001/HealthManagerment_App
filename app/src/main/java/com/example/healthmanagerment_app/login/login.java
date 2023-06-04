package com.example.healthmanagerment_app.login;

import static androidx.core.content.ContextCompat.getSystemService;

import android.Manifest;
import android.annotation.SuppressLint;
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

import android.util.Log;
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
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends Fragment {
    TextView tt,tk,mk;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Button login = (Button) view.findViewById(R.id.button123);
        tt = view.findViewById(R.id.textView6);
        tk = view.findViewById(R.id.editTextText);
        mk = view.findViewById(R.id.editTextText2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                    user.setAccount(tk.getText().toString());
                    user.setPassword(mk.getText().toString());
//                user.setAccount("1");
//                user.setPassword("1");
                Log.v("abcde", new Gson().toJson(user));
                    API methods = ServerJWT.getRetrofit().create(API.class);
                    Call<Token> call = methods.login(user);
                    call.enqueue(new Callback<Token>() {
                        @Override
                        public void onResponse(Call<Token> call, Response<Token> response) {
                            Token tk = response.body();
                            Log.v("mess",tk.message);
                            if(tk.message.equals("ok")){
                                Bundle bundle = new Bundle();
                                bundle.putString("acc", tk.data.get(0).Account);
                                Navigation.findNavController(view).navigate(R.id.action_login2_to_mainScreen,bundle);
                            } else {
                                tt.setText(tk.message.toString());
                            }

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