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
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class info extends Fragment {
    TextView name,birthday,age,address,phone,height,weight,userjob,benhly,tieusu,text01;
    ImageView qr_codeinfo;
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
        qr_codeinfo= view.findViewById(R.id.qr_codeinfo);
        User user = new User();
        user.setAccount("1");
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
                tieusu.setText(dt.data.get(0).getUserWeight().toString());
                text01.setText("text01");

                MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
                BitMatrix bitMatrix= null;
                try {
                    bitMatrix = multiFormatWriter.encode(text01.getText().toString(), BarcodeFormat.QR_CODE,150,150);
                    BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
                    Bitmap bitmap=barcodeEncoder.createBitmap(bitMatrix);
                } catch (WriterException e) {
                    throw new RuntimeException(e);
                }
            }


            @Override
            public void onFailure(Call<Data> call, Throwable t) {

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