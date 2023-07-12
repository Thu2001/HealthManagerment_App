package com.example.healthmanagerment_app.donthuoc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

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

public class qr_view_thuoc extends AppCompatActivity {
    ImageView qr_view_codethuoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_view_thuoc);
        qr_view_codethuoc=findViewById(R.id.qr_codeviewthuoc);
        Bundle extras = getIntent().getExtras();
        String id = extras.getString("acc");

        StringBuilder textToSend = new StringBuilder();
        textToSend.append(id);
        MultiFormatWriter writer=new MultiFormatWriter();
        try {
            BitMatrix matrix=writer.encode(textToSend.toString(), BarcodeFormat.QR_CODE,300,300);
            BarcodeEncoder encoder=new BarcodeEncoder();
            Bitmap bitmap=encoder.createBitmap(matrix);
            qr_view_codethuoc.setImageBitmap(bitmap);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }


    }
}