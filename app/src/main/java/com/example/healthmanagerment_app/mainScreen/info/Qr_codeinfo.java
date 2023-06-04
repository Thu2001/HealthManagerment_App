package com.example.healthmanagerment_app.mainScreen.info;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.api.API;
import com.example.healthmanagerment_app.api.RetrofitClient;
import com.example.healthmanagerment_app.model.Data;
import com.example.healthmanagerment_app.model.User;
import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Qr_codeinfo extends AppCompatActivity {
    ImageView qr_codeinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_codeinfo);
        Bundle extras = getIntent().getExtras();
        String id = extras.getString("acc");
        qr_codeinfo= findViewById(R.id.qr_codeinfo);
        User user = new User();
        user.setAccount(id);
        Log.v("aaaaaaaaa",new Gson().toJson(user));

        API methods = RetrofitClient.getRetrofit().create(API.class);

        Call<Data> call = methods.getInfo(user);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Data dt = response.body();
                String name = dt.data.get(0).userName;
                String birthday = dt.data.get(0).getUserDate();
                String address = dt.data.get(0).userAddress;
                String maBN = dt.data.get(0).codeinfouser;

                StringBuilder textToSend = new StringBuilder();
                textToSend.append("Tên: "+ name+"|"+" patient code: "+maBN+"\nbirthday: "+birthday+"|"+" address: "+address);
                MultiFormatWriter writer=new MultiFormatWriter();
                try {
                    BitMatrix matrix=writer.encode(textToSend.toString(), BarcodeFormat.QR_CODE,300,300);
                    BarcodeEncoder encoder=new BarcodeEncoder();
                    Bitmap bitmap=encoder.createBitmap(matrix);
                    qr_codeinfo.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    throw new RuntimeException(e);
                }
            }


            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }

        });
    }
}