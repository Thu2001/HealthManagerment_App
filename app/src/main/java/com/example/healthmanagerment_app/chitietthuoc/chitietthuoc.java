package com.example.healthmanagerment_app.chitietthuoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.healthmanagerment_app.R;
import com.example.healthmanagerment_app.api.API;
import com.example.healthmanagerment_app.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class chitietthuoc extends AppCompatActivity {
    TextView nameT,SXT,addressT,functionT,dosageT,ngaySXT,ngayHHT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietthuoc);
        nameT = findViewById(R.id.tenthuoc);
        SXT = findViewById(R.id.noiSX);
        addressT = findViewById(R.id.addressT);
        functionT = findViewById(R.id.congdungthuoc);
        dosageT = findViewById(R.id.lieudungthuoc);
        ngaySXT = findViewById(R.id.ngaySXT);
        ngayHHT = findViewById(R.id.ngayHHT);
        Bundle extras = getIntent().getExtras();

        String id = extras.getString("codeT");

        thongtinthuoc.Thongtinthuoc thongTinthuoc = new thongtinthuoc.Thongtinthuoc();

        thongTinthuoc.setCodeT(id);

        API methods = RetrofitClient.getRetrofit().create(API.class);

        Call<thongtinthuoc> call = methods.chitietthuoc(thongTinthuoc);

        call.enqueue(new Callback<thongtinthuoc>() {
            @Override
            public void onResponse(Call<thongtinthuoc> call, Response<thongtinthuoc> response) {
                thongtinthuoc dt = response.body();
                nameT.setText(dt.data.get(0).getNameT().toString());
                SXT.setText(dt.data.get(0).getSXT().toString());
                addressT.setText(dt.data.get(0).getAddressT().toString());
                functionT.setText(dt.data.get(0).getFunctionT().toString());
                dosageT.setText(dt.data.get(0).getDosageT().toString());
                ngaySXT.setText(dt.data.get(0).getNgaySXT().toString());
                ngayHHT.setText(dt.data.get(0).getNgayHHT().toString());
            }

            @Override
            public void onFailure(Call<thongtinthuoc> call, Throwable t) {

            }
        });

    }
}