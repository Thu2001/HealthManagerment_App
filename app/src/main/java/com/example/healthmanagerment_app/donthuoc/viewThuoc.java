package com.example.healthmanagerment_app.donthuoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.api.API;
import com.example.healthmanagerment_app.api.RetrofitClient;
import com.example.healthmanagerment_app.chitietthuoc.thongtinthuoc;
import com.example.healthmanagerment_app.mainScreen.info.Qr_codeinfo;
import com.example.healthmanagerment_app.model.Data;
import com.example.healthmanagerment_app.model.ResponePrescription;
import com.example.healthmanagerment_app.model.User;
import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class viewThuoc extends AppCompatActivity {
    TextView name;
    DownloadManager manager;
    ImageView qr_codeviewthuoc;
    Button bt_dw;
    private RecyclerView rcvthuoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_thuoc);
        rcvthuoc=findViewById(R.id.rcv_thuoc);
        Bundle extras = getIntent().getExtras();
        String id = extras.getString("idPres");
        String a123 = extras.getString("url_link_qr_code");
        Log.v("fff",id);
        ResponePrescription.Prescription temp = new ResponePrescription.Prescription();
        temp.setIdPres(id);

        API methods = RetrofitClient.getRetrofit().create(API.class);

        Call<thongtinthuoc> call = methods.getListThuoc(temp);

        call.enqueue(new Callback<thongtinthuoc>() {
            @Override
            public void onResponse(Call<thongtinthuoc> call, Response<thongtinthuoc> response) {
                thongtinthuoc data = response.body();

                ArrayList<thongtinthuoc.Thongtinthuoc> listdonThuoc = new ArrayList<>();
                for (thongtinthuoc.Thongtinthuoc dt:data.data
                ) {
                    listdonThuoc.add(dt);
                }
                ThuocAdapter thuocAdapter = new ThuocAdapter(viewThuoc.this,listdonThuoc);
                LinearLayoutManager LinearLayoutManager=new LinearLayoutManager(viewThuoc.this, RecyclerView.VERTICAL,false);
                rcvthuoc.setLayoutManager(LinearLayoutManager);
                rcvthuoc.setAdapter(thuocAdapter);
            }

            @Override
            public void onFailure(Call<thongtinthuoc> call, Throwable t) {

            }
        });

        qr_codeviewthuoc=findViewById(R.id.qr_codeviewthuoc1);
        StringBuilder textToSend = new StringBuilder();
        textToSend.append(id);
        MultiFormatWriter writer=new MultiFormatWriter();
        try {
            BitMatrix matrix=writer.encode(textToSend.toString(), BarcodeFormat.QR_CODE,150,150);
            BarcodeEncoder encoder=new BarcodeEncoder();
            Bitmap bitmap=encoder.createBitmap(matrix);
            qr_codeviewthuoc.setImageBitmap(bitmap);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }


        Button bt_dw = findViewById(R.id.download);
        bt_dw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                long reference = manager.enqueue(request);
            }
        });

        name = findViewById(R.id.usernamehome);
        User user = new User();
        user.setAccount("1");
        Log.v("aaaaaaaaa",new Gson().toJson(user));

        Button a1=findViewById(R.id.bt_qrcodeviewthuoc);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewThuoc.this, qr_view_thuoc.class);
                intent.putExtra("acc",a123);
                startActivity(intent);
            }
        });

        API methods1 = RetrofitClient.getRetrofit().create(API.class);

        Call<Data> call1 = methods1.getInfo(user);
        call1.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Data dt = response.body();
                name.setText(dt.data.get(0).getUserName().toString());

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }

        });

    }
    private List<thuoc> getlist(){
        List<thuoc> list=new ArrayList<>();
        list.add(new thuoc("Tên Thuốc 1" ,"ngày 3 viên " , "15 viên"));
        list.add(new thuoc("Tên Thuốc 2" ,"ngày 3 viên " , "15 viên"));
        list.add(new thuoc("Tên Thuốc 3" ,"ngày 3 viên " , "15 viên"));
        list.add(new thuoc("Tên Thuốc 4" ,"ngày 3 viên " , "15 viên"));
        list.add(new thuoc("Tên Thuốc 5" ,"ngày 3 viên " , "15 viên"));
        list.add(new thuoc("Tên Thuốc 6" ,"ngày 3 viên " , "15 viên"));

        return list;
    }
}