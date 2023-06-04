package com.example.healthmanagerment_app.mainScreen.info.uploadinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.api.API;
import com.example.healthmanagerment_app.api.RetrofitClient;
import com.example.healthmanagerment_app.model.Data;
import com.example.healthmanagerment_app.model.User;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class uploadinfo1 extends AppCompatActivity {
    EditText username,age,userDate,userJob,userAddress,userPhone,userHeight,userWeight,benhly,tieusu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadinfo1);
        Bundle extras = getIntent().getExtras();

        String id = extras.getString("acc");
        Button uploaduser= findViewById(R.id.btnuploaduser);
        username = findViewById(R.id.editname);
        age = findViewById(R.id.edituoi);
        userDate = findViewById(R.id.editngaysinh);
        userJob = findViewById(R.id.editcongviec);
        userAddress = findViewById(R.id.editdiachi);
        userPhone = findViewById(R.id.editlienhe);
        userHeight = findViewById(R.id.editchieucao);
        userWeight = findViewById(R.id.editcannang);
        benhly = findViewById(R.id.editbenhly);
        tieusu = findViewById(R.id.edittieusu);
        User user = new User();
        user.setAccount(id);
        Log.v("aaaaaaaaa",new Gson().toJson(user));

        API methods = RetrofitClient.getRetrofit().create(API.class);

        Call<Data> call = methods.getInfo(user);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Data dt = response.body();
                if(dt.data.get(0).userName == null){
                    username.setText("");
                } else {
                    if (!dt.data.get(0).userName.equals("")){
                        username.setText(dt.data.get(0).getUserName().toString());
                    }
                }
                if(dt.data.get(0).age == null){
                    age.setText("");
                } else {
                    if (!dt.data.get(0).age.equals("")){
                        age.setText(dt.data.get(0).getAge().toString());
                    }
                }
                if(dt.data.get(0).userJob == null){
                    userJob.setText("");
                } else {
                    if (!dt.data.get(0).getUserJob().equals("")){
                        userJob.setText(dt.data.get(0).getUserJob().toString());
                    }
                }
                if(dt.data.get(0).birthday == null){
                    userDate.setText("");
                } else {
                    if (!dt.data.get(0).birthday.equals("")){
                        userDate.setText(dt.data.get(0).getUserDate().toString());
                    }
                }
                if(dt.data.get(0).userAddress == null){
                    userAddress.setText("");
                } else {
                    if (!dt.data.get(0).userAddress.equals("")){
                        userAddress.setText(dt.data.get(0).getUserAddress().toString());
                    }
                }
                if(dt.data.get(0).userPhone == null){
                    userPhone.setText("");
                } else {
                    if (!dt.data.get(0).userPhone.equals("")){
                        userPhone.setText(dt.data.get(0).getUserPhone().toString());
                    }
                }

                if(dt.data.get(0).userHeight == null){
                    userHeight.setText("");
                } else {
                    if (!dt.data.get(0).userHeight.equals("")){
                        userHeight.setText(dt.data.get(0).getUserHeight().toString());
                    }
                }
                if(dt.data.get(0).userWeight == null){
                    userWeight.setText("");
                } else {
                    if (!dt.data.get(0).userWeight.equals("")){
                        userWeight.setText(dt.data.get(0).getUserWeight().toString());
                    }
                }
                if(dt.data.get(0).benhly == null){
                    benhly.setText("");
                } else {
                    if (!dt.data.get(0).benhly.equals("")){
                        benhly.setText(dt.data.get(0).getUserWeight().toString());
                    }
                }
                if(dt.data.get(0).tieusu == null){
                    tieusu.setText("");
                } else {
                    if (!dt.data.get(0).tieusu.equals("")){
                        tieusu.setText(dt.data.get(0).getTieusu().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }

        });
        uploaduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setAccount(id);
                user.setUserName(username.getText().toString());
                user.setAge(age.getText().toString());
                user.setUserDate(userDate.getText().toString());
                user.setUserJob(userJob.getText().toString());
                user.setUserAddress(userAddress.getText().toString());
                user.setUserPhone(userPhone.getText().toString());
                user.setUserHeight(userHeight.getText().toString());
                user.setUserWeight(userWeight.getText().toString());
                user.setBenhly(benhly.getText().toString());
                user.setTieusu(tieusu.getText().toString());

                API methods = RetrofitClient.getRetrofit().create(API.class);
                Call<Data> call = methods.uploaduser(user);
                call.enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {

                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {

                    }
                });
            }

        });
    }

}