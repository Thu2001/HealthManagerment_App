package com.example.healthmanagerment_app.mainScreen.info;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.RequiresPermission;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.api.API;
import com.example.healthmanagerment_app.api.RetrofitClient;
import com.example.healthmanagerment_app.mainScreen.info.uploadinfo.uploadinfo1;
import com.example.healthmanagerment_app.model.User;
import com.example.healthmanagerment_app.model.Data;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class info extends Fragment {
    TextView name,birthday,age,address,phone,height,weight,userjob,benhly,tieusu,maBN;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        name = view.findViewById(R.id.name);
        age = view.findViewById(R.id.age);
        userjob = view.findViewById(R.id.userJob);
        birthday = view.findViewById(R.id.birthday);
        address = view.findViewById(R.id.address);
        phone = view.findViewById(R.id.phone);
        height = view.findViewById(R.id.height);
        weight = view.findViewById(R.id.weight);
        benhly = view.findViewById(R.id.benhly);
        tieusu = view.findViewById(R.id.tieusu);
        maBN = view.findViewById(R.id.codeinfouser);

        String data = getArguments().getString("data");

        User user = new User();
        user.setAccount(data);
        Log.v("aaaaaaaaa",new Gson().toJson(user));

        API methods = RetrofitClient.getRetrofit().create(API.class);

        Call<Data> call = methods.getInfo(user);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Data dt = response.body();
                name.setText(dt.data.get(0).getUserName().toString());
                age.setText(dt.data.get(0).getAge().toString());
                userjob.setText(dt.data.get(0).getUserJob().toString());
                birthday.setText(dt.data.get(0).getUserDate().toString());
                address.setText(dt.data.get(0).getUserAddress().toString());
                phone.setText(dt.data.get(0).getUserPhone().toString());
                height.setText(dt.data.get(0).getUserHeight().toString());
                weight.setText(dt.data.get(0).getUserWeight().toString());
                benhly.setText(dt.data.get(0).getUserWeight().toString());
                tieusu.setText(dt.data.get(0).getTieusu().toString());
//                maBN.setText(dt.data.get(0).getCodeinfouser().toString());

            }


            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }

        });

        Button qt_codeinfo=view.findViewById(R.id.bt_qrcodeinfo);
        qt_codeinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Qr_codeinfo.class);
                getActivity().startActivity(intent);
            }
        });


        Button uploadTT= view.findViewById(R.id.captt);
        uploadTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), uploadinfo1.class);
                getActivity().startActivity(intent);
            }
        });

        return view;
    }
}